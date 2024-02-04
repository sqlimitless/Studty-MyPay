package com.mypay.money.application.service;

import com.mypay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.mypay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.mypay.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.mypay.money.application.port.in.DecreaseMoneyRequestCommand;
import com.mypay.money.application.port.in.DecreaseMoneyRequestUseCase;
import com.mypay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.mypay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.mypay.money.application.port.out.DecreaseMoneyPort;
import com.mypay.money.application.port.out.IncreaseMoneyPort;
import com.mypay.money.domain.ChangingMoneyStatus;
import com.mypay.money.domain.ChangingType;
import com.mypay.money.domain.MemberMoney;
import com.mypay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class DecreaseMoneyRequestService implements DecreaseMoneyRequestUseCase {

    private final DecreaseMoneyPort decreaseMoneyPort;

    @Override
    public MoneyChangingRequest decreaseMoneyRequest(DecreaseMoneyRequestCommand command) {

        // 머니의 충전.증액이라는 과정
        // 1. 고객 정보가 정상인지 확인 (멤버)

        // 2. 고객의 연동된 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한지도 확인 (뱅킹)

        // 3. 법인 계좌 상태도 정상인지 확인 (뱅킹)

        // 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest 를 생성한다. (MoneyChangingRequest)

        // 5. 펌뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌) (뱅킹)

        // 6-1. 결과가 정상적이라면. 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴
        // 성공 시에 멤버의 MemberMoney 값 증액이 필요해요
        MemberMoney memberMoney = MemberMoney.builder().memberMoneyId(command.getTargetMembershipId()).balance(command.getAmount()).build();
        MemberMoneyJpaEntity memberMoneyJpaEntity = decreaseMoneyPort.decreaseMoney(memberMoney);

        if (memberMoneyJpaEntity != null) {
            MoneyChangingRequest moneyChangingRequest = MoneyChangingRequest.builder()
                    .targetMembershipId(command.getTargetMembershipId())
                    .changingType(ChangingType.DECREASE)
                    .changingMoneyAmount(command.getAmount())
                    .changingMoneyStatus(ChangingMoneyStatus.SUCCESS)
                    .uuid(UUID.randomUUID())
                    .build();

            MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity = decreaseMoneyPort.createMoneyChangingRequest(moneyChangingRequest);
            return MoneyChangingRequestMapper.mapToDomainEntity(moneyChangingRequestJpaEntity);
        }

        // 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴
        return MoneyChangingRequest.builder()
                .targetMembershipId(command.getTargetMembershipId())
                .changingType(ChangingType.DECREASE)
                .changingMoneyAmount(command.getAmount())
                .changingMoneyStatus(ChangingMoneyStatus.FAIL)
                .uuid(UUID.randomUUID())
                .build();
    }
}
