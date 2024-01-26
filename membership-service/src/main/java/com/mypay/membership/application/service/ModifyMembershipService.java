package com.mypay.membership.application.service;


import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membership.adapter.out.persistence.MembershipMapper;
import com.mypay.membership.application.port.in.ModifyMembershipCommand;
import com.mypay.membership.application.port.in.ModifyMembershipUseCase;
import com.mypay.membership.application.port.out.ModifyMembershipPort;
import com.mypay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    @Override
    @Transactional
    public Membership modifyMembership(ModifyMembershipCommand modifyMembershipCommand) {
        MembershipJpaEntity membershipJpaEntity = modifyMembershipPort.modifyMembership(modifyMembershipCommand);
        return MembershipMapper.mapToDomainEntity(membershipJpaEntity);
    }
}
