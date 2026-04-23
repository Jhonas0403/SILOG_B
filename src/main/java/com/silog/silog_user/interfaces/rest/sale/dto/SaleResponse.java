package com.silog.silog_user.interfaces.rest.sale.dto;

import com.silog.silog_user.domain.model.Sale;

import java.time.LocalDateTime;
import java.util.UUID;

public class SaleResponse {
    private UUID id;
    private LocalDateTime saleDate;
    private Double total;
    private Boolean status;
    private UUID createdBy;
    private UUID updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static SaleResponse fromDomain(Sale sale) {
        if (sale == null) {
            return null;
        }
        SaleResponse response = new SaleResponse();
        response.setId(sale.getId());
        response.setSaleDate(sale.getSaleDate());
        response.setTotal(sale.getTotal());
        response.setStatus(sale.getStatus());
        response.setCreatedBy(sale.getCreatedBy());
        response.setUpdatedBy(sale.getUpdatedBy());
        response.setCreatedAt(sale.getCreatedAt());
        response.setUpdatedAt(sale.getUpdatedAt());
        return response;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
