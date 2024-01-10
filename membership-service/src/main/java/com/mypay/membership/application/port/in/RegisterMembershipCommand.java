package com.mypay.membership.application.port.in;

import com.mypay.membership.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    //    @NotNull
    @NotBlank
    private final String name;
    //    @NotNull
    @NotBlank
    private final String email;
    //    @NotNull
    @NotBlank
    private final String adress;

    @AssertTrue
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
