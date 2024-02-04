package com.mypay.money.adapter.out.persistence;

import com.mypay.common.PersistenceAdapter;
import com.mypay.money.application.port.out.DecreaseMoneyPort;
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
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort, DecreaseMoneyPort {

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
        MemberMoneyJpaEntity entity;
        List<MemberMoneyJpaEntity> entityList = memberMoneyRepository.findByMembershipId(Long.parseLong(memberMoney.getMembershipId()));
        if (entityList != null) {
            entity = entityList.get(0);
            entity.increaseMoney(memberMoney.getBalance());
        } else {
            entity = MemberMoneyJpaEntity.builder()
                    .membershipId(Long.parseLong(memberMoney.getMembershipId()))
                    .balance(memberMoney.getBalance())
                    .build();
            memberMoneyRepository.save(entity);
        }
        return entity;
    }

    @Override
    public MemberMoneyJpaEntity decreaseMoney(MemberMoney memberMoney) {
        MemberMoneyJpaEntity entity;
        List<MemberMoneyJpaEntity> entityList = memberMoneyRepository.findByMembershipId(Long.parseLong(memberMoney.getMembershipId()));
        if (entityList != null) {
            entity = entityList.get(0);
            entity.decreaseMoney(memberMoney.getBalance());
        } else {
            entity = null;
        }
        return entity;
    }
}