package com.silog.silog_user.interfaces.rest.saledetail.dto;

import com.silog.silog_user.domain.model.SaleDetail;

import java.math.BigDecimal;
import java.util.UUID;

public class SaleDetailRequest {
    private UUID saleId;
    private UUID variantId;
    private Integer quantity;
    // BUG FIX: was Double — changed to BigDecimal
    private BigDecimal salePrice;
    private BigDecimal purchasePrice;
    private Boolean status;

    public SaleDetail toDomain() {
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSaleId(saleId);
        saleDetail.setVariantId(variantId);
        saleDetail.setQuantity(quantity);
        saleDetail.setSalePrice(salePrice);
        saleDetail.setPurchasePrice(purchasePrice);
        saleDetail.setStatus(status);
        // Note: createdBy is now handled automatically by AuditingEntityListener
        return saleDetail;
    }

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

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
