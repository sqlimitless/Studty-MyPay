package com.mypay.banking.adapter.out.persistance;

import com.mypay.banking.application.port.out.FindBankAccountPort;
import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.domain.FindBankAccount;
import com.mypay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankAccountPersistence implements RegisterBankAccountPort, FindBankAccountPort {

    private final SpringDataBankAccountRepository springDataBankAccountRepository;

    @Override
    public BankAccountJpaEntity registerBankAccount(RegisteredBankAccount registeredBankAccount) {
        BankAccountJpaEntity bankAccountJpaEntity = BankAccountJpaEntity.builder()
                .membershipId(registeredBankAccount.getMembershipId())
                .bankId(registeredBankAccount.getBankId())
                .bankAccountNumber(registeredBankAccount.getBankAccountNumber())
                .linkedStatusIsValid(registeredBankAccount.isLinkedStatusIsValid())
                .build();
        return springDataBankAccountRepository.save(bankAccountJpaEntity);
    }

    @Override
    public BankAccountJpaEntity findBankAccount(FindBankAccount bankAccount) {
        return springDataBankAccountRepository.getById(Long.valueOf(bankAccount.getBankAccountId()));
    }
}
