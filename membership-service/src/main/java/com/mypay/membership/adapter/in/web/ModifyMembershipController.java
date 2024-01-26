package com.mypay.membership.adapter.in.web;

import com.mypay.membership.application.port.in.ModifyMembershipCommand;
import com.mypay.membership.application.port.in.ModifyMembershipUseCase;
import com.mypay.membership.common.WebAdapter;
import com.mypay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;


    @PatchMapping("/membership")
    public ResponseEntity<Membership> modifyMembership(ModifyMembershipRequest request) {
        ModifyMembershipCommand modifyMembershipCommand = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .adress(request.getAddress())
                .name(request.getName())
                .email(request.getEmail())
                .isCorp(request.isCorp())
                .isValid(request.isValid())
                .build();
        Membership membership = modifyMembershipUseCase.modifyMembership(modifyMembershipCommand);
        return ResponseEntity.ok(membership);
    }
}
