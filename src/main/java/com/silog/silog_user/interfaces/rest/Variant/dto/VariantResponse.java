package com.silog.silog_user.interfaces.rest.Variant.dto;

import com.silog.silog_user.domain.model.Variant;

import java.time.LocalDateTime;
import java.util.UUID;

public class VariantResponse {
    private UUID id;
    private UUID productId;
    private String name;
    private String barcode;
    private Integer order;
    private Integer stock;
    private Double purchasePrice;
    private Double salePrice;
    private Double minSalePrice;
    private Boolean status;
    private UUID createdBy;
    private UUID updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static VariantResponse fromDomain(Variant variant) {
        if (variant == null) {
            return null;
        }
        VariantResponse response = new VariantResponse();
        response.setId(variant.getId());
        response.setProductId(variant.getProductId());
        response.setName(variant.getName());
        response.setBarcode(variant.getBarcode());
        response.setOrder(variant.getOrder());
        response.setStock(variant.getStock());
        response.setPurchasePrice(variant.getPurchasePrice());
        response.setSalePrice(variant.getSalePrice());
        response.setMinSalePrice(variant.getMinSalePrice());
        response.setStatus(variant.getStatus());
        response.setCreatedBy(variant.getCreatedBy());
        response.setUpdatedBy(variant.getUpdatedBy());
        response.setCreatedAt(variant.getCreatedAt());
        response.setUpdatedAt(variant.getUpdatedAt());
        return response;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getMinSalePrice() {
        return minSalePrice;
    }

    public void setMinSalePrice(Double minSalePrice) {
        this.minSalePrice = minSalePrice;
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
