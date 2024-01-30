package com.mypay.banking.application.port.in;

import com.mypay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class FindBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    private String registeredBankAccountId;

    public FindBankAccountCommand(String registeredBankAccountId) {
        this.registeredBankAccountId = registeredBankAccountId;
        validateSelf();
    }
}
