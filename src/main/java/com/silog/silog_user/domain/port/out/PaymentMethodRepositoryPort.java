package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.PaymentMethod;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentMethodRepositoryPort {
    PaymentMethod save(PaymentMethod paymentMethod);
    List<PaymentMethod> findAll();
    Optional<PaymentMethod> findById(UUID id);
}
