package com.mypay.money.application.port.out;

import com.mypay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.mypay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.mypay.money.domain.MemberMoney;
import com.mypay.money.domain.MoneyChangingRequest;

public interface DecreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingRequest(MoneyChangingRequest moneyChangingRequest);
    MemberMoneyJpaEntity decreaseMoney(MemberMoney memberMoney);
}
