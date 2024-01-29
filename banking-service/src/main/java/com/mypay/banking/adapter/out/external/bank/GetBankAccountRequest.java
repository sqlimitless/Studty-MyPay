package com.mypay.banking.adapter.out.external.bank;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetBankAccountRequest {
    private String bankName;
    private String BankAccountNumber;
    private boolean isValid;
}
