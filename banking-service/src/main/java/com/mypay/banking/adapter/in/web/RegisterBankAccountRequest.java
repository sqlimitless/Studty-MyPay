package com.mypay.banking.adapter.in.web;

import lombok.Data;

@Data
public class RegisterBankAccountRequest {

    private String membershipId;
    private String bankId;
    private String bankAccountNumber;
    private boolean linkedStatusIsValid;
}
