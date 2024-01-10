package com.mypay.membership.application.service;

import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membership.adapter.out.persistence.MembershipMapper;
import com.mypay.membership.application.port.in.FindMembershipCommand;
import com.mypay.membership.application.port.in.FindMembershipUseCase;
import com.mypay.membership.application.port.out.FindMembershipPort;
import com.mypay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    @Override
    public Membership findMembership(FindMembershipCommand findMembershipCommand) {
        MembershipJpaEntity membershipJpaEntity = findMembershipPort.findMembership(findMembershipCommand.getMembershipId());
        return MembershipMapper.mapToDomainEntity(membershipJpaEntity);
    }
}
