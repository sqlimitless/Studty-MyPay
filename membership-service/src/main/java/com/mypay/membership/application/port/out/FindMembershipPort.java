package com.mypay.membership.application.port.out;

import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(String membershipId);
}
