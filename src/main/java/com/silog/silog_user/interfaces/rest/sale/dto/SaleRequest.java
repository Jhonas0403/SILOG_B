package com.silog.silog_user.interfaces.rest.sale.dto;

import com.silog.silog_user.domain.model.Sale;

import java.time.LocalDateTime;
import java.util.UUID;

public class SaleRequest {
    private LocalDateTime saleDate;
    private Double total;
    private Boolean status;
    private UUID createdBy;

    public Sale toDomain() {
        Sale sale = new Sale();
        sale.setSaleDate(saleDate);
        sale.setTotal(total);
        sale.setStatus(status);
        sale.setCreatedBy(createdBy);
        return sale;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }
}
