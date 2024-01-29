package com.mypay.banking.application.port.in;

import com.mypay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    @NotNull
    private String registeredBankAccountId;
    @NotNull
    private String membershipId;
    @NotNull
    private String bankId;
    @NotNull
    private String bankAccountNumber;
    @NotNull
    private boolean linkedStatusIsValid;

    public RegisterBankAccountCommand(@NotNull String registeredBankAccountId, @NotNull String membershipId, @NotNull String bankId, @NotNull String bankAccountNumber, @NotNull boolean linkedStatusIsValid) {
        this.registeredBankAccountId = registeredBankAccountId;
        this.membershipId = membershipId;
        this.bankId = bankId;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
        validateSelf();
    }
}
