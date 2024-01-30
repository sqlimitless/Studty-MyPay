package com.mypay.banking.adapter.in.web;

import com.mypay.banking.application.port.in.FindBankAccountCommand;
import com.mypay.banking.application.port.in.FindBankAccountUseCase;
import com.mypay.banking.domain.FindBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindBankAccountController {

    private final FindBankAccountUseCase findBankAccountUseCase;

    @GetMapping("/banking/account/{registeredBankAccountId}")
    public ResponseEntity<FindBankAccount> findBankAccount(@PathVariable("registeredBankAccountId") String registeredBankAccountId) {
        FindBankAccount bankAccount = findBankAccountUseCase.findBankAccount(FindBankAccountCommand.builder()
                .registeredBankAccountId(registeredBankAccountId)
                .build());
        return ResponseEntity.ok(bankAccount);
    }
}
