package com.mypay.banking.application.port.in;

import com.mypay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RequestFirmBankingCommand extends SelfValidating<RequestFirmBankingCommand> {
    @NotNull
    private final String fromBankName;

    @NotNull
    private final String fromBankAccountNumber;

    @NotNull
    private final String toBankName;

    @NotNull
    private final String toBankAccountNumber;

    private final int moneyAmount;
}