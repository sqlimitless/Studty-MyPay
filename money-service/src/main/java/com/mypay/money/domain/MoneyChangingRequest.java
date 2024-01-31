package com.mypay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class MoneyChangingRequest {
    private String moneyChangingRequestId;
    // 어떤 고객의 증액/감액 요청을 요청했는지의 멤버 정보
    private String targetMembershipId;
    // 그 요청이 증액 요청인지 / 감액 요청인지
    private ChangingType changingType;
    // 증액 또는 감액 요청의 금액
    private int changingMoneyAmount;
    // 머니 변액 요청에 대한 상태
    private ChangingMoneyStatus changingMoneyStatus;
    private UUID uuid;
    private LocalDateTime createdAt;
}

