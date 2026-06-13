package com.silog.silog_user.interfaces.rest.sale.dto;

import com.silog.silog_user.domain.model.Sale;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public class SaleResponse {
    private UUID id;
    private ZonedDateTime saleDate;
    private BigDecimal total;
    private Boolean status;
    private UUID storeId;
    private UUID paymentMethodId;
    private String operationCode;

    public static SaleResponse fromDomain(Sale sale) {
        if (sale == null) return null;
        SaleResponse response = new SaleResponse();
        response.setId(sale.getId());
        response.setSaleDate(sale.getSaleDate());
        response.setTotal(sale.getTotal());
        response.setStatus(sale.getStatus());
        response.setStoreId(sale.getStoreId());
        response.setPaymentMethodId(sale.getPaymentMethodId());
        response.setOperationCode(sale.getOperationCode());
        return response;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public ZonedDateTime getSaleDate() { return saleDate; }
    public void setSaleDate(ZonedDateTime saleDate) { this.saleDate = saleDate; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public UUID getStoreId() { return storeId; }
    public void setStoreId(UUID storeId) { this.storeId = storeId; }

    public UUID getPaymentMethodId() { return paymentMethodId; }
    public void setPaymentMethodId(UUID paymentMethodId) { this.paymentMethodId = paymentMethodId; }

    public String getOperationCode() { return operationCode; }
    public void setOperationCode(String operationCode) { this.operationCode = operationCode; }
}
