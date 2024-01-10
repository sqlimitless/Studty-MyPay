package com.mypay.membership.application.port.in;

import com.mypay.membership.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    private String membershipId;

    public FindMembershipCommand(String membershipId) {
        this.membershipId = membershipId;
        this.validateSelf();
    }
}
