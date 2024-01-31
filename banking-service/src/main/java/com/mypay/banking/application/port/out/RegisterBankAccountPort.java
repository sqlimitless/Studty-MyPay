package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.persistence.BankAccountJpaEntity;
import com.mypay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    BankAccountJpaEntity registerBankAccount(RegisteredBankAccount registeredBankAccount);
}
