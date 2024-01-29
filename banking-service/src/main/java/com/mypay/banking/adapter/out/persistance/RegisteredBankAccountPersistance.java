package com.mypay.banking.adapter.out.persistance;

import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisteredBankAccountPersistance implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository springDataRegisteredBankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity registerBankAccount(RegisteredBankAccount registeredBankAccount) {
        RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity = RegisteredBankAccountJpaEntity.builder()
                .membershipId(registeredBankAccount.getMembershipId())
                .bankId(registeredBankAccount.getBankId())
                .bankAccountNumber(registeredBankAccount.getBankAccountNumber())
                .linkedStatusIsValid(registeredBankAccount.isLinkedStatusIsValid())
                .build();
        return springDataRegisteredBankAccountRepository.save(registeredBankAccountJpaEntity);
    }
}
