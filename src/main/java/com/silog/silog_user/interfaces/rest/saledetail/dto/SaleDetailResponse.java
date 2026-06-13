package com.silog.silog_user.interfaces.rest.saledetail.dto;

import com.silog.silog_user.domain.model.SaleDetail;

import java.math.BigDecimal;
import java.util.UUID;

public class SaleDetailResponse {
    private UUID id;
    private UUID saleId;
    private UUID variantId;
    private Integer quantity;
    // BUG FIX: was Double — changed to BigDecimal
    private BigDecimal salePrice;
    private BigDecimal purchasePrice;
    private BigDecimal subtotal;
    private Boolean status;

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
        return response;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getSaleId() { return saleId; }
    public void setSaleId(UUID saleId) { this.saleId = saleId; }

    public UUID getVariantId() { return variantId; }
    public void setVariantId(UUID variantId) { this.variantId = variantId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getSalePrice() { return salePrice; }
    public void setSalePrice(BigDecimal salePrice) { this.salePrice = salePrice; }

    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
