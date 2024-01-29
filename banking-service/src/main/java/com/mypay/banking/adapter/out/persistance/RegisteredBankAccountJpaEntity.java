package com.mypay.banking.adapter.out.persistance;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisteredBankAccountJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registeredBankAccountId;
    private String membershipId;
    private String bankId;
    private String bankAccountNumber;
    private boolean linkedStatusIsValid;


    @Builder
    public RegisteredBankAccountJpaEntity(Long registeredBankAccountId, String membershipId, String bankId, String bankAccountNumber, boolean linkedStatusIsValid) {
        this.registeredBankAccountId = registeredBankAccountId;
        this.membershipId = membershipId;
        this.bankId = bankId;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }
}
