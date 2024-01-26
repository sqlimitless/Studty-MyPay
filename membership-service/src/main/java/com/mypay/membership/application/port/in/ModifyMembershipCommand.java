package com.mypay.membership.application.port.in;


import com.mypay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;


@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

    private String membershipId;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String adress;

    @NotNull
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
