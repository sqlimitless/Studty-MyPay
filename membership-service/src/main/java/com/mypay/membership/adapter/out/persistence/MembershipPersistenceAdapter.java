package com.mypay.membership.adapter.out.persistence;

import com.mypay.membership.application.port.out.FindMembershipPort;
import com.mypay.membership.application.port.out.RegisterMembershipPort;
import com.mypay.membership.common.PersistenceAdapter;
import com.mypay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

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
}
