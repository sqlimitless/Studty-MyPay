package com.mypay.banking.application.port.in;

import com.mypay.banking.domain.FindBankAccount;

public interface FindBankAccountUseCase {

    FindBankAccount findBankAccount(FindBankAccountCommand findBankAccountCommand);
}
