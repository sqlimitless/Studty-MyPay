package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.persistance.BankAccountJpaEntity;
import com.mypay.banking.adapter.out.persistance.FindBankAccountMapper;
import com.mypay.banking.application.port.in.FindBankAccountCommand;
import com.mypay.banking.application.port.in.FindBankAccountUseCase;
import com.mypay.banking.application.port.out.FindBankAccountPort;
import com.mypay.banking.domain.FindBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FindBankAccountService implements FindBankAccountUseCase {


    private final FindBankAccountPort findBankAccountPort;
    @Override
    public FindBankAccount findBankAccount(FindBankAccountCommand findBankAccountCommand) {

        FindBankAccount findBankAccount = FindBankAccount.builder()
                .bankAccountId(findBankAccountCommand.getRegisteredBankAccountId())
                .build();

        BankAccountJpaEntity bankAccountJpaEntity = findBankAccountPort.findBankAccount(findBankAccount);
        return FindBankAccountMapper.mapToDomainEntity(bankAccountJpaEntity);
    }
}
