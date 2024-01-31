package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.mypay.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingPort {

    FirmBankingRequestJpaEntity createFirmBankingRequest(FirmBankingRequest firmBankingRequest);
}
