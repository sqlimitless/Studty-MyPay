package com.mypay.membership.adapter.out.persistence;

import com.mypay.common.PersistenceAdapter;
import com.mypay.membership.application.port.in.ModifyMembershipCommand;
import com.mypay.membership.application.port.out.FindMembershipPort;
import com.mypay.membership.application.port.out.ModifyMembershipPort;
import com.mypay.membership.application.port.out.RegisterMembershipPort;

import com.mypay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository springDataMembershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return springDataMembershipRepository.save(MembershipJpaEntity.builder()
                .name(membershipName.getNameValue())
                .address(membershipAddress.getAddressValue())
                .email(membershipEmail.getEmailValue())
                .isValid(membershipIsValid.isValidValue())
                .isCorp(membershipIsCorp.isCorpValue())
                .build());
    }

    @Override
    public MembershipJpaEntity findMembership(String membershipId) {
        return springDataMembershipRepository.getById(Long.valueOf(membershipId));
    }

    @Override
    public MembershipJpaEntity modifyMembership(ModifyMembershipCommand modifyMembershipCommand) {
        MembershipJpaEntity membershipJpaEntity = springDataMembershipRepository.findById(Long.valueOf(modifyMembershipCommand.getMembershipId()))
                .orElseThrow(NoSuchElementException::new);
        membershipJpaEntity.updateMembership(
                modifyMembershipCommand.getName(),
                modifyMembershipCommand.getAdress(),
                modifyMembershipCommand.getEmail(),
                modifyMembershipCommand.isValid(),
                modifyMembershipCommand.isCorp()
        );
        return springDataMembershipRepository.save(membershipJpaEntity);
    }
}
