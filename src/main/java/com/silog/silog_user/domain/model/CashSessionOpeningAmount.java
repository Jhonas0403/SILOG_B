package com.silog.silog_user.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class CashSessionOpeningAmount {
    private UUID id;
    private UUID cashSessionId;
    private UUID paymentMethodId;
    private BigDecimal amount;

    public CashSessionOpeningAmount() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getCashSessionId() { return cashSessionId; }
    public void setCashSessionId(UUID cashSessionId) { this.cashSessionId = cashSessionId; }

    public UUID getPaymentMethodId() { return paymentMethodId; }
    public void setPaymentMethodId(UUID paymentMethodId) { this.paymentMethodId = paymentMethodId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
