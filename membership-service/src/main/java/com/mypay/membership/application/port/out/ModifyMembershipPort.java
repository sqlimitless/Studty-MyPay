package com.mypay.membership.application.port.out;

import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membership.application.port.in.ModifyMembershipCommand;

public interface ModifyMembershipPort {
    MembershipJpaEntity modifyMembership(ModifyMembershipCommand modifyMembershipCommand);
}
