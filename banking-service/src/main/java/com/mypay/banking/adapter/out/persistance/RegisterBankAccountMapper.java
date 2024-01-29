package com.mypay.banking.adapter.out.persistance;

import com.mypay.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisterBankAccountMapper {

    public static RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity){
        return RegisteredBankAccount.builder()
                .registeredBankAccountId(String.valueOf(registeredBankAccountJpaEntity.getRegisteredBankAccountId()))
                .membershipId(registeredBankAccountJpaEntity.getMembershipId())
                .bankId(registeredBankAccountJpaEntity.getBankId())
                .bankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber())
                .linkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
                .build();
    }
}
