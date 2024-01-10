package com.mypay.membership.adapter.out.persistence;

import com.mypay.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    public static Membership mapToDomainEntity(MembershipJpaEntity membershipJpaEntity){
        return  Membership.generateMember(
                new Membership.MembershipId(String.valueOf(membershipJpaEntity.getMembershipId())),
                new Membership.MembershipName(membershipJpaEntity.getName()),
                new Membership.MembershipEmail(membershipJpaEntity.getEmail()),
                new Membership.MembershipAddress(membershipJpaEntity.getAddress()),
                new Membership.MembershipIsValid(membershipJpaEntity.isValid()),
                new Membership.MembershipIsCorp(membershipJpaEntity.isCorp())
        );
    }
}
