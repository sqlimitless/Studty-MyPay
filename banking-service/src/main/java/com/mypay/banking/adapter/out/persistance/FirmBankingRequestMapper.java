package com.mypay.banking.adapter.out.persistance;

import com.mypay.banking.domain.FirmBankingRequest;

import java.util.UUID;

public class FirmBankingRequestMapper {
    public static FirmBankingRequest mapToDomainEntity(FirmBankingRequestJpaEntity firmBankingRequestJpaEntity){
        return FirmBankingRequest.builder()
                .firmBankingRequestId(String.valueOf(firmBankingRequestJpaEntity.getRequestFirmBankingId()))
                .fromBankName(firmBankingRequestJpaEntity.getFromBankName())
                .fromBankAccountNumber(firmBankingRequestJpaEntity.getFromBankAccountNumber())
                .toBankName(firmBankingRequestJpaEntity.getToBankName())
                .toBankAccountNumber(firmBankingRequestJpaEntity.getToBankAccountNumber())
                .moneyAmount(firmBankingRequestJpaEntity.getMoneyAmount())
                .firmBankingStatus(firmBankingRequestJpaEntity.getFirmBankingStatus())
                .uuid(UUID.fromString(firmBankingRequestJpaEntity.getUuid()))
                .build();
    }
}
