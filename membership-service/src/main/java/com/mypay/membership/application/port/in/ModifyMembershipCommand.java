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
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

    private String membershipId;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String adress;

    @AssertTrue
    private boolean isValid;

    private boolean isCorp;


    public ModifyMembershipCommand(String membershipId, String name, String email, String adress, boolean isValid, boolean isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.validateSelf();
    }

}
