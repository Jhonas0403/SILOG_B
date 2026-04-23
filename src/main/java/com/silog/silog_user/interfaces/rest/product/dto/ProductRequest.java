package com.silog.silog_user.interfaces.rest.product.dto;

import com.silog.silog_user.domain.model.Product;

import java.util.UUID;

public class ProductRequest {
    private String name;
    private UUID brandId;
    private Boolean status;
    private UUID createdBy;

    public Product toDomain() {
        Product product = new Product();
        product.setName(name);
        product.setBrandId(brandId);
        product.setStatus(status);
        product.setCreatedBy(createdBy);
        return product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getBrandId() {
        return brandId;
    }

    public void setBrandId(UUID brandId) {
        this.brandId = brandId;
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
