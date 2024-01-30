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
public class BankAccountJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankAccountId;
    private String membershipId;
    private String bankId;
    private String bankAccountNumber;
    private boolean linkedStatusIsValid;


    @Builder
    public BankAccountJpaEntity(Long bankAccountId, String membershipId, String bankId, String bankAccountNumber, boolean linkedStatusIsValid) {
        this.bankAccountId = bankAccountId;
        this.membershipId = membershipId;
        this.bankId = bankId;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }
}
