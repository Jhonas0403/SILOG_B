package com.silog.silog_user.interfaces.rest.cashsession.dto;

import com.silog.silog_user.domain.model.CashSessionReportItem;

import java.math.BigDecimal;
import java.util.UUID;

public class CashSessionReportItemResponse {
    private UUID paymentMethodId;
    private String paymentMethodName;
    private BigDecimal openingAmount;
    private BigDecimal salesTotal;
    private BigDecimal expectedTotal;

    public static CashSessionReportItemResponse fromDomain(CashSessionReportItem item) {
        CashSessionReportItemResponse dto = new CashSessionReportItemResponse();
        dto.paymentMethodId = item.getPaymentMethodId();
        dto.paymentMethodName = item.getPaymentMethodName();
        dto.openingAmount = item.getOpeningAmount();
        dto.salesTotal = item.getSalesTotal();
        dto.expectedTotal = item.getExpectedTotal();
        return dto;
    }

    public UUID getPaymentMethodId() { return paymentMethodId; }
    public String getPaymentMethodName() { return paymentMethodName; }
    public BigDecimal getOpeningAmount() { return openingAmount; }
    public BigDecimal getSalesTotal() { return salesTotal; }
    public BigDecimal getExpectedTotal() { return expectedTotal; }
}
