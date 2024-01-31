package com.mypay.money.adapter.out.persistence;

import com.mypay.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MoneyChangingRequestMapper {
    public static MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity) {
        return MoneyChangingRequest.builder()
                .moneyChangingRequestId(String.valueOf(moneyChangingRequestJpaEntity.getMoneyChangingRequestId()))
                .targetMembershipId(moneyChangingRequestJpaEntity.getTargetMembershipId())
                .changingType(moneyChangingRequestJpaEntity.getMoneyChangingType())
                .changingMoneyAmount(moneyChangingRequestJpaEntity.getMoneyAmount())
                .changingMoneyStatus(moneyChangingRequestJpaEntity.getChangingMoneyStatus())
                .uuid(UUID.fromString(moneyChangingRequestJpaEntity.getUuid()))
                .build();
    }
}
