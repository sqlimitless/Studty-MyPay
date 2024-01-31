package com.mypay.banking.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataFirmBankingRequestRepository extends JpaRepository<FirmBankingRequestJpaEntity, Long> {
}
