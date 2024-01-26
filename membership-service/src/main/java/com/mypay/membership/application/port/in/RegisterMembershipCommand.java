package com.mypay.membership.application.port.in;


import com.mypay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;


@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NotNull
    private final String name;
    @NotNull
    private final String email;
    @NotNull
    private final String adress;

    private final boolean isValid;

    private final boolean isCorp;


    public RegisterMembershipCommand(String name, String email, String adress, boolean isValid, boolean isCorp) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.isValid = isValid;
        this.isCorp = isCorp;

        this.validateSelf();
    }
}
