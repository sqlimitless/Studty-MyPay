package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

    public static RegisteredBankAccount mapToDomainEntity(BankAccountJpaEntity bankAccountJpaEntity){
        return RegisteredBankAccount.builder()
                .registeredBankAccountId(String.valueOf(bankAccountJpaEntity.getBankAccountId()))
                .membershipId(bankAccountJpaEntity.getMembershipId())
                .bankId(bankAccountJpaEntity.getBankId())
                .bankAccountNumber(bankAccountJpaEntity.getBankAccountNumber())
                .linkedStatusIsValid(bankAccountJpaEntity.isLinkedStatusIsValid())
                .build();
    }
}
