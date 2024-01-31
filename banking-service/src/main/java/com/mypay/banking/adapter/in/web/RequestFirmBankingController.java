package com.mypay.banking.adapter.in.web;

import com.mypay.banking.application.port.in.RequestFirmBankingCommand;
import com.mypay.banking.application.port.in.RequestFirmBankingUseCase;
import com.mypay.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmbankingUseCase;

    @PostMapping("/banking/firmbanking/request")
    public ResponseEntity<FirmBankingRequest> requestFirmBanking(@RequestBody RequestFirmBankingRequest requestFirmBankingRequest) {

        RequestFirmBankingCommand requestFirmBankingCommand = RequestFirmBankingCommand.builder()
                .fromBankName(requestFirmBankingRequest.getFromBankName())
                .fromBankAccountNumber(requestFirmBankingRequest.getFromBankAccountNumber())
                .toBankName(requestFirmBankingRequest.getToBankName())
                .toBankAccountNumber(requestFirmBankingRequest.getToBankAccountNumber())
                .moneyAmount(requestFirmBankingRequest.getMoneyAmount())
                .build();
        FirmBankingRequest firmBankingRequest = requestFirmbankingUseCase.requestFirmBanking(requestFirmBankingCommand);
        return ResponseEntity.ok(firmBankingRequest);
    }
}
