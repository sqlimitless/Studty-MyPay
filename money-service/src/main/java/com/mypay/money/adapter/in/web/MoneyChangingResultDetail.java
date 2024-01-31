package com.mypay.money.adapter.in.web;

import com.mypay.money.domain.ChangingMoneyStatus;
import com.mypay.money.domain.ChangingType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoneyChangingResultDetail {
    private String moneyChangingRequestId;
    private ChangingType moneyChangingType;
    private ChangingMoneyStatus moneyChangingResultStatus;
    private int amount;

}
