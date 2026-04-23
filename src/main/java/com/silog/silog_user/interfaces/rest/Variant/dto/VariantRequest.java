package com.silog.silog_user.interfaces.rest.Variant.dto;

import com.silog.silog_user.domain.model.Variant;

import java.util.UUID;

public class VariantRequest {
    private UUID productId;
    private String name;
    private String barcode;
    private Integer stock;
    private Double purchasePrice;
    private Double salePrice;
    private Double minSalePrice;
    private Boolean status;
    private UUID createdBy;

    public Variant toDomain() {
        Variant variant = new Variant();
        variant.setProductId(productId);
        variant.setName(name);
        variant.setBarcode(barcode);
        variant.setStock(stock);
        variant.setPurchasePrice(purchasePrice);
        variant.setSalePrice(salePrice);
        variant.setMinSalePrice(minSalePrice);
        variant.setStatus(status);
        variant.setCreatedBy(createdBy);
        return variant;
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
}
