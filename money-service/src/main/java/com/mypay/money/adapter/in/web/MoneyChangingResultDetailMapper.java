package com.mypay.money.adapter.in.web;

import com.mypay.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingResultDetailMapper {

    public static MoneyChangingResultDetail mapToMoneyChangingResultDetail(MoneyChangingRequest moneyChangingRequest) {
        return MoneyChangingResultDetail.builder()
                .moneyChangingRequestId(moneyChangingRequest.getMoneyChangingRequestId())
                .moneyChangingType(moneyChangingRequest.getChangingType())
                .moneyChangingResultStatus(moneyChangingRequest.getChangingMoneyStatus())
                .amount(moneyChangingRequest.getChangingMoneyAmount()).build();
    }
}
