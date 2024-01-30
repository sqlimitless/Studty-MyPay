package com.mypay.banking.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataBankAccountRepository extends JpaRepository<BankAccountJpaEntity,Long> {
}
