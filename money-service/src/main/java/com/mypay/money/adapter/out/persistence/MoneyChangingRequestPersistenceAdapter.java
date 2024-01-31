package com.mypay.money.adapter.out.persistence;

import com.mypay.common.PersistenceAdapter;
import com.mypay.money.application.port.out.IncreaseMoneyPort;
import com.mypay.money.domain.MemberMoney;
import com.mypay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@PersistenceAdapter
@Component
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

    private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

    private final SpringDataMemberMoneyRepository memberMoneyRepository;

    @Override
    public MoneyChangingRequestJpaEntity createMoneyChangingRequest(MoneyChangingRequest moneyChangingRequest) {
        MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity = MoneyChangingRequestJpaEntity.builder()
                .targetMembershipId(moneyChangingRequest.getTargetMembershipId())
                .moneyChangingType(moneyChangingRequest.getChangingType())
                .moneyAmount(moneyChangingRequest.getChangingMoneyAmount())
                .timestamp(LocalDateTime.now())
                .changingMoneyStatus(moneyChangingRequest.getChangingMoneyStatus())
                .uuid(String.valueOf(moneyChangingRequest.getUuid()))
                .build();

        return moneyChangingRequestRepository.save(moneyChangingRequestJpaEntity);
    }

    @Override
    public MemberMoneyJpaEntity increaseMoney(MemberMoney memberMoney) {
        MemberMoneyJpaEntity entity = null;
        List<MemberMoneyJpaEntity> entityList = memberMoneyRepository.findByMembershipId(Long.parseLong(memberMoney.getMembershipId()));


//            entity.setBalance(entity.getBalance() + increaseMoneyAmount);
        if (entityList != null) {
            entity = entityList.get(0);
            memberMoneyRepository.save(entity);
        } else {
//            entity = new MemberMoneyJpaEntity(
//                    Long.parseLong(memberId.getMembershipId()),
//                    increaseMoneyAmount
//            );
//            entity = memberMoneyRepository.save(entity);
        }
        return entity;
        }
    }