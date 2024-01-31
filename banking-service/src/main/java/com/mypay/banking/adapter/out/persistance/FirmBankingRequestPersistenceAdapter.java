package com.mypay.banking.adapter.out.persistance;

import com.mypay.banking.application.port.out.RequestFirmBankingPort;
import com.mypay.banking.domain.FirmBankingRequest;
import com.mypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmBankingRequestPersistenceAdapter implements RequestFirmBankingPort {

    private final SpringDataFirmBankingRequestRepository firmBankingRequestRepository;


    @Override
    public FirmBankingRequestJpaEntity createFirmBankingRequest(FirmBankingRequest firmBankingRequest) {
        FirmBankingRequestJpaEntity firmBankingRequestJpaEntity = FirmBankingRequestJpaEntity.builder()
                .fromBankName(firmBankingRequest.getFromBankName())
                .fromBankAccountNumber(firmBankingRequest.getFromBankAccountNumber())
                .toBankName(firmBankingRequest.getToBankName())
                .toBankAccountNumber(firmBankingRequest.getToBankAccountNumber())
                .moneyAmount(firmBankingRequest.getMoneyAmount())
                .firmBankingStatus(firmBankingRequest.getFirmBankingStatus())
                .uuid(String.valueOf(firmBankingRequest.getUuid()))
                .build();
        return firmBankingRequestRepository.save(firmBankingRequestJpaEntity);
    }
}
