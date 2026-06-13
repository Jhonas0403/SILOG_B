package com.silog.silog_user.infrastructure.repository.jpa;

import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentMethodSalesProjection {
    UUID getPaymentMethodId();
    BigDecimal getTotal();
}
