package com.mypay.money.application.port.in;

import com.mypay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class DecreaseMoneyRequestCommand extends SelfValidating<DecreaseMoneyRequestCommand>{
    @NotNull
    private final String targetMembershipId;

    @NotNull
    private final int amount;


    public DecreaseMoneyRequestCommand(@NotNull String targetMembershipId, @NotNull int amount) {
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;
        this.validateSelf();
    }
}
