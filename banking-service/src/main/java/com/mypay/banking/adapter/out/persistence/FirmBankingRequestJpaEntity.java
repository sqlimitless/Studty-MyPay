package com.mypay.banking.adapter.out.persistence;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request_firmbanking")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FirmBankingRequestJpaEntity {

    @Id
    @GeneratedValue
    private Long requestFirmBankingId;
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private int moneyAmount;
    private int firmBankingStatus;
    private String uuid;

    @Builder
    public FirmBankingRequestJpaEntity(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount, int firmBankingStatus, String uuid) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.firmBankingStatus = firmBankingStatus;
        this.uuid = uuid;
    }

    public void updateFirmbankingStatus(int resultCode) {
        if (resultCode == 0) {
            this.firmBankingStatus = 1;
        } else {
            this.firmBankingStatus = 0;
        }
    }
}
