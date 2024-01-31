package com.mypay.money.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class MemberMoney {

    private String memberMoneyId;
    private String membershipId;
    private int balance;
}
