package com.mypay.banking.adapter.out.persistance;

import com.mypay.banking.domain.FindBankAccount;
import org.springframework.stereotype.Component;

@Component
public class FindBankAccountMapper {

    public static FindBankAccount mapToDomainEntity(BankAccountJpaEntity bankAccountJpaEntity) {
        return FindBankAccount.builder()
                .bankAccountId(String.valueOf(bankAccountJpaEntity.getBankAccountId()))
                .membershipId(bankAccountJpaEntity.getMembershipId())
                .bankId(bankAccountJpaEntity.getBankId())
                .bankAccountNumber(bankAccountJpaEntity.getBankAccountNumber())
                .linkedStatusIsValid(bankAccountJpaEntity.isLinkedStatusIsValid())
                .build();
    }
}
