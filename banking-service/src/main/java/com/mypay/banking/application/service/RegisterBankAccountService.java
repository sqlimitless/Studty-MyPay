package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.external.bank.BankAccount;
import com.mypay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.mypay.banking.adapter.out.persistance.RegisterBankAccountMapper;
import com.mypay.banking.adapter.out.persistance.RegisteredBankAccountJpaEntity;
import com.mypay.banking.application.port.in.RegisterBankAccountCommand;
import com.mypay.banking.application.port.in.RegisterBankAccountUseCase;
import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand registerBankAccountCommand) {
        BankAccount bankAccountInfo = requestBankAccountInfoPort.getBankAccountInfo(
                GetBankAccountRequest.builder()
                        .bankName(registerBankAccountCommand.getBankId())
                        .BankAccountNumber(registerBankAccountCommand.getBankAccountNumber())
                        .isValid(registerBankAccountCommand.isLinkedStatusIsValid())
                        .build()
        );

        if(bankAccountInfo.isValid()){
            RegisteredBankAccount registeredBankAccount = RegisteredBankAccount.builder()
                    .registeredBankAccountId(registerBankAccountCommand.getRegisteredBankAccountId())
                    .membershipId(registerBankAccountCommand.getMembershipId())
                    .bankId(registerBankAccountCommand.getBankId())
                    .bankAccountNumber(registerBankAccountCommand.getBankAccountNumber())
                    .linkedStatusIsValid(registerBankAccountCommand.isLinkedStatusIsValid())
                    .build();
            RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity = registerBankAccountPort.registerBankAccount(registeredBankAccount);
            return RegisterBankAccountMapper.mapToDomainEntity(registeredBankAccountJpaEntity);
        }else{
            return null;
        }
    }
}
