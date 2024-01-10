package com.mypay.membership.adapter.in.web;

import com.mypay.membership.application.port.in.RegisterMembershipCommand;
import com.mypay.membership.application.port.in.RegisterMembershipUseCase;
import com.mypay.membership.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    void registerMemberShip (@RequestBody RegisterMemberShipRequest registerMemberShipRequest){
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(registerMemberShipRequest.getName())
                .email(registerMemberShipRequest.getEmail())
                .adress(registerMemberShipRequest.getAddress())
                .isValid(true)
                .isCorp(registerMemberShipRequest.isCorp())
                .build();

        registerMembershipUseCase.registerMembership(command);
    }
}
