package com.silog.silog_user.domain.port.in.PaymentMethod;

import com.silog.silog_user.domain.model.PaymentMethod;

import java.util.List;

public interface GetPaymentMethodsUseCase {
    List<PaymentMethod> getAll();
}
