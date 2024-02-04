package com.mypay.money.application.port.in;

import com.mypay.money.domain.MoneyChangingRequest;

public interface DecreaseMoneyRequestUseCase {
    MoneyChangingRequest decreaseMoneyRequest(DecreaseMoneyRequestCommand command);
}
