package com.mypay.money.adapter.out.persistence;

import com.mypay.money.domain.ChangingMoneyStatus;
import com.mypay.money.domain.ChangingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "money_changing_request")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MoneyChangingRequestJpaEntity {

    @Id
    @GeneratedValue
    private Long moneyChangingRequestId;
    private String targetMembershipId;
    @Enumerated(EnumType.STRING)
    private ChangingType moneyChangingType;
    private int moneyAmount;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timestamp;
    @Enumerated(EnumType.STRING)
    private ChangingMoneyStatus changingMoneyStatus;
    private String uuid;
}
