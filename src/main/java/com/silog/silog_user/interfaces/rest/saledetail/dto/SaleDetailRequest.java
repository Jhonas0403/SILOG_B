package com.silog.silog_user.interfaces.rest.saledetail.dto;

import com.silog.silog_user.domain.model.SaleDetail;

import java.util.UUID;

public class SaleDetailRequest {
    private UUID saleId;
    private UUID variantId;
    private Integer quantity;
    private Double salePrice;
    private Double purchasePrice;
    private Boolean status;
    private UUID createdBy;

    public SaleDetail toDomain() {
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSaleId(saleId);
        saleDetail.setVariantId(variantId);
        saleDetail.setQuantity(quantity);
        saleDetail.setSalePrice(salePrice);
        saleDetail.setPurchasePrice(purchasePrice);
        saleDetail.setStatus(status);
        saleDetail.setCreatedBy(createdBy);
        return saleDetail;
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
