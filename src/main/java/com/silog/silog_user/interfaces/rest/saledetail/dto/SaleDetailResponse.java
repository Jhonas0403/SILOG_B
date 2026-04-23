package com.silog.silog_user.interfaces.rest.saledetail.dto;

import com.silog.silog_user.domain.model.SaleDetail;

import java.time.LocalDateTime;
import java.util.UUID;

public class SaleDetailResponse {
    private UUID id;
    private UUID saleId;
    private UUID variantId;
    private Integer quantity;
    private Double salePrice;
    private Double purchasePrice;
    private Double subtotal;
    private Boolean status;
    private UUID createdBy;
    private UUID updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static SaleDetailResponse fromDomain(SaleDetail saleDetail) {
        if (saleDetail == null) {
            return null;
        }
        SaleDetailResponse response = new SaleDetailResponse();
        response.setId(saleDetail.getId());
        response.setSaleId(saleDetail.getSaleId());
        response.setVariantId(saleDetail.getVariantId());
        response.setQuantity(saleDetail.getQuantity());
        response.setSalePrice(saleDetail.getSalePrice());
        response.setPurchasePrice(saleDetail.getPurchasePrice());
        response.setSubtotal(saleDetail.getSubtotal());
        response.setStatus(saleDetail.getStatus());
        response.setCreatedBy(saleDetail.getCreatedBy());
        response.setUpdatedBy(saleDetail.getUpdatedBy());
        response.setCreatedAt(saleDetail.getCreatedAt());
        response.setUpdatedAt(saleDetail.getUpdatedAt());
        return response;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSaleId() {
        return saleId;
    }

    public void setSaleId(UUID saleId) {
        this.saleId = saleId;
    }

    public UUID getVariantId() {
        return variantId;
    }

    public void setVariantId(UUID variantId) {
        this.variantId = variantId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
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
