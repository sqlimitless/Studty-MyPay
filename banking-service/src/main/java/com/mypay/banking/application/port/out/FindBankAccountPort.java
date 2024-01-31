package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.persistence.BankAccountJpaEntity;
import com.mypay.banking.domain.FindBankAccount;

public interface FindBankAccountPort {

    BankAccountJpaEntity findBankAccount(FindBankAccount findBankAccount);
}
