package com.mypay.money.adapter.in.web;

import lombok.Data;

@Data
public class IncreaseMoneyChangingRequest {

    private String targetMembershipId;
    private int amount;
}
