package com.mypay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class FindBankAccount {

    private String bankAccountId;
    private String membershipId;
    private String bankId;
    private String bankAccountNumber;
    private boolean linkedStatusIsValid;
}
