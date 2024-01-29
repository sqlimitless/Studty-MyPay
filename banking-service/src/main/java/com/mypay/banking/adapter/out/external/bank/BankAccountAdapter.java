package com.mypay.banking.adapter.out.external.bank;

import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest getBankAccountRequest) {
        return BankAccount.builder()
                .bankName(getBankAccountRequest.getBankName())
                .BankAccountNumber(getBankAccountRequest.getBankAccountNumber())
                .isValid(getBankAccountRequest.isValid())
                .build();
    }
}
