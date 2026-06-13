package com.silog.silog_user.domain.port.in.PaymentMethod;

import com.silog.silog_user.domain.model.PaymentMethod;

public interface CreatePaymentMethodUseCase {
    PaymentMethod create(PaymentMethod paymentMethod);
}
