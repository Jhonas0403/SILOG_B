package com.silog.silog_user.interfaces.rest.sale.dto;

import com.silog.silog_user.domain.model.Sale;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public class SaleRequest {
    private ZonedDateTime saleDate;
    private BigDecimal total;
    private Boolean status;
    private UUID paymentMethodId;
    private String operationCode;

    public Sale toDomain() {
        Sale sale = new Sale();
        sale.setSaleDate(saleDate);
        sale.setTotal(total);
        sale.setStatus(status);
        sale.setPaymentMethodId(paymentMethodId);
        sale.setOperationCode(operationCode);
        return sale;
    }

    public ZonedDateTime getSaleDate() { return saleDate; }
    public void setSaleDate(ZonedDateTime saleDate) { this.saleDate = saleDate; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public UUID getPaymentMethodId() { return paymentMethodId; }
    public void setPaymentMethodId(UUID paymentMethodId) { this.paymentMethodId = paymentMethodId; }

    public String getOperationCode() { return operationCode; }
    public void setOperationCode(String operationCode) { this.operationCode = operationCode; }
}
