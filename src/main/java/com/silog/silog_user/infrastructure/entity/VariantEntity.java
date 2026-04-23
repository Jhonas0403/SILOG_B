package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product_variants")
public class VariantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "variant_id", nullable = false, updatable = false)
    private UUID variantId;

    @Column(name = "variant_product_id")
    private UUID variantProductId;

    @Column(name = "variant_name")
    private String variantName;

    @Column(name = "variant_barcode")
    private String variantBarcode;

    @Column(name = "variant_stock")
    private Integer variantStock;

    @Column(name = "variant_purchase_price")
    private Double variantPurchasePrice;

    @Column(name = "variant_sale_price")
    private Double variantSalePrice;

    @Column (name = "variant_min_sale_price")
    private Double variantMinSalePrice;

    @Column (name = "variant_order")
    private Integer variantOrder;

    @Column (name = "variant_status")
    private Boolean variantStatus;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public VariantEntity() {}

    public UUID getVariantId() {
        return variantId;
    }

    public void setVariantId(UUID variantId) {
        this.variantId = variantId;
    }

    public UUID getVariantProductId() {
        return variantProductId;
    }

    public void setVariantProductId(UUID variantProductId) {
        this.variantProductId = variantProductId;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getVariantBarcode() {
        return variantBarcode;
    }

    public void setVariantBarcode(String variantBarcode) {
        this.variantBarcode = variantBarcode;
    }

    public Integer getVariantStock() {
        return variantStock;
    }

    public void setVariantStock(Integer variantStock) {
        this.variantStock = variantStock;
    }

    public Double getVariantPurchasePrice() {
        return variantPurchasePrice;
    }

    public void setVariantPurchasePrice(Double variantPurchasePrice) {
        this.variantPurchasePrice = variantPurchasePrice;
    }

    public Double getVariantSalePrice() {
        return variantSalePrice;
    }

    public void setVariantSalePrice(Double variantSalePrice) {
        this.variantSalePrice = variantSalePrice;
    }

    public Double getVariantMinSalePrice() {
        return variantMinSalePrice;
    }

    public void setVariantMinSalePrice(Double variantMinSalePrice) {
        this.variantMinSalePrice = variantMinSalePrice;
    }

    public Integer getVariantOrder() {
        return variantOrder;
    }

    public void setVariantOrder(Integer variantOrder) {
        this.variantOrder = variantOrder;
    }

    public Boolean getVariantStatus() {
        return variantStatus;
    }

    public void setVariantStatus(Boolean variantStatus) {
        this.variantStatus = variantStatus;
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
