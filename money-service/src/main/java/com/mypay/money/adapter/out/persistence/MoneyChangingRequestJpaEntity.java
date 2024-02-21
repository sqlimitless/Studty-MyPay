package com.mypay.money.adapter.out.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime timestamp;
    @Enumerated(EnumType.STRING)
    private ChangingMoneyStatus changingMoneyStatus;
    private String uuid;
}
