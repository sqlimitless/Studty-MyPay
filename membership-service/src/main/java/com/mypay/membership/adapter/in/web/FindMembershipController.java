package com.mypay.membership.adapter.in.web;

import com.mypay.membership.application.port.in.FindMembershipCommand;
import com.mypay.membership.application.port.in.FindMembershipUseCase;
import com.mypay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;
    @GetMapping(path = "/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipByMemberId(@PathVariable("membershipId") String membershipId){
        FindMembershipCommand membershipCommand = FindMembershipCommand
                .builder().membershipId(membershipId).build();
        Membership membership = findMembershipUseCase.findMembership(membershipCommand);
        return ResponseEntity.ok(membership);
    }
}
