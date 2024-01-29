package com.mypay.banking.adapter.in.web;

import com.mypay.banking.application.port.in.RegisterBankAccountCommand;
import com.mypay.banking.application.port.in.RegisterBankAccountUseCase;
import com.mypay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/banking/account")
    public ResponseEntity<RegisteredBankAccount> registerBankAccount(RegisterBankAccountRequest registerBankAccountRequest) {
        RegisterBankAccountCommand registerBankAccountCommand = RegisterBankAccountCommand.builder()
                .membershipId(registerBankAccountRequest.getMembershipId())
                .bankId(registerBankAccountRequest.getBankId())
                .bankAccountNumber(registerBankAccountRequest.getBankAccountNumber())
                .linkedStatusIsValid(registerBankAccountRequest.isLinkedStatusIsValid())
                .build();
        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(registerBankAccountCommand);
        if(registeredBankAccount == null){
            throw new NoSuchElementException("없음");
        }
        return ResponseEntity.ok(registeredBankAccount);
    }
}
