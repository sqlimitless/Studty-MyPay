package com.mypay.banking.adapter.out.external.bank;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BankAccount {

    private String bankName;
    private String BankAccountNumber;
    private boolean isValid;

}
