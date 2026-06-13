package com.silog.silog_user.domain.port.in.PaymentMethod;

import com.silog.silog_user.domain.model.PaymentMethod;

import java.util.UUID;

public interface GetPaymentMethodByIdUseCase {
    PaymentMethod getById(UUID id);
}
