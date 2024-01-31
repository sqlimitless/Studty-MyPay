package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.mypay.banking.adapter.out.external.bank.FirmBankingResult;
import com.mypay.banking.adapter.out.persistance.FirmBankingRequestJpaEntity;
import com.mypay.banking.adapter.out.persistance.FirmBankingRequestMapper;
import com.mypay.banking.application.port.in.RequestFirmBankingCommand;
import com.mypay.banking.application.port.in.RequestFirmBankingUseCase;
import com.mypay.banking.application.port.out.RequestExternalFirmBankingPort;
import com.mypay.banking.application.port.out.RequestFirmBankingPort;
import com.mypay.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RequestFirmBankingPort requestFirmBankingPort;
    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;

    @Override
    public FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command) {
        FirmBankingRequest firmBankingRequest = FirmBankingRequest.builder()
                .fromBankName(command.getFromBankName())
                .fromBankAccountNumber(command.getFromBankAccountNumber())
                .toBankName(command.getToBankName())
                .toBankAccountNumber(command.getToBankAccountNumber())
                .moneyAmount(command.getMoneyAmount())
                .firmBankingStatus(0)
                .uuid(UUID.randomUUID())
                .build();
        FirmBankingRequestJpaEntity firmBankingRequestJpaEntity = requestFirmBankingPort.createFirmBankingRequest(firmBankingRequest);

        ExternalFirmBankingRequest externalFirmBankingRequest = ExternalFirmBankingRequest.builder()
                .fromBankName(firmBankingRequest.getFromBankName())
                .fromBankAccountNumber(firmBankingRequest.getFromBankAccountNumber())
                .toBankName(firmBankingRequest.getToBankName())
                .toBankAccountNumber(firmBankingRequest.getToBankAccountNumber())
                .build();
        FirmBankingResult firmBankingResult = requestExternalFirmBankingPort.requestExternalFirmBanking(externalFirmBankingRequest);

        firmBankingRequestJpaEntity.updateFirmbankingStatus(firmBankingResult.getResultCode());
        return FirmBankingRequestMapper.mapToDomainEntity(firmBankingRequestJpaEntity);
    }
}
