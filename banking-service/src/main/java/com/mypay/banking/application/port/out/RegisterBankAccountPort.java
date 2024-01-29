package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.persistance.RegisteredBankAccountJpaEntity;
import com.mypay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity registerBankAccount(RegisteredBankAccount registeredBankAccount);
}
