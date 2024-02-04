package com.mypay.money.adapter.in.web;

import com.mypay.money.application.port.in.DecreaseMoneyRequestCommand;
import com.mypay.money.application.port.in.DecreaseMoneyRequestUseCase;
import com.mypay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.mypay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.mypay.money.domain.ChangingMoneyStatus;
import com.mypay.money.domain.ChangingType;
import com.mypay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {

    private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;
    private final DecreaseMoneyRequestUseCase decreaseMoneyRequestUseCase;

    @PostMapping(path = "/money/increase")
    ResponseEntity<MoneyChangingResultDetail> increaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {
        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
                .targetMembershipId(request.getTargetMembershipId())
                .amount(request.getAmount())
                .build();

        MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);

        // MoneyChangingRequest -> MoneyChangingResultDetail
        MoneyChangingResultDetail resultDetail = MoneyChangingResultDetail.builder()
                .moneyChangingRequestId(moneyChangingRequest.getMoneyChangingRequestId())
                .moneyChangingType(moneyChangingRequest.getChangingType())
                .moneyChangingResultStatus(moneyChangingRequest.getChangingMoneyStatus())
                .amount(moneyChangingRequest.getChangingMoneyAmount())
                .build();

        return ResponseEntity.ok(resultDetail);
    }

    @PostMapping(path = "/money/decrease")
    ResponseEntity<MoneyChangingResultDetail> decreaseMoneyChangingRequest(@RequestBody DecreaseMoneyChangingRequest request) {
        DecreaseMoneyRequestCommand command = DecreaseMoneyRequestCommand.builder()
                .targetMembershipId(request.getTargetMembershipId())
                .amount(request.getAmount())
                .build();

        MoneyChangingRequest moneyChangingRequest = decreaseMoneyRequestUseCase.decreaseMoneyRequest(command);

        // MoneyChangingRequest -> MoneyChangingResultDetail
        MoneyChangingResultDetail resultDetail = MoneyChangingResultDetail.builder()
                .moneyChangingRequestId(moneyChangingRequest.getMoneyChangingRequestId())
                .moneyChangingType(moneyChangingRequest.getChangingType())
                .moneyChangingResultStatus(moneyChangingRequest.getChangingMoneyStatus())
                .amount(moneyChangingRequest.getChangingMoneyAmount())
                .build();

        return ResponseEntity.ok(resultDetail);
    }
}
