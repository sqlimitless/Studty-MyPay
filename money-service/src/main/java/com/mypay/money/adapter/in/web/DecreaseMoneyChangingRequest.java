package com.mypay.money.adapter.in.web;

import lombok.Data;

@Data
public class DecreaseMoneyChangingRequest {

    private String targetMembershipId;
    private int amount;
}
