package com.silog.silog_user.interfaces.rest.brand.dto;

import com.silog.silog_user.domain.model.Brand;

import java.util.UUID;

public class BrandRequest {
    private String name;
    private String description;
    private UUID subcategoryId;
    private Boolean status;
    private UUID createdBy;

    public Brand toDomain() {
        Brand brand = new Brand();
        brand.setName(name);
        brand.setDescription(description);
        brand.setSubcategoryId(subcategoryId);
        brand.setStatus(status);
        brand.setCreatedBy(createdBy);
        return brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(UUID subcategoryId) {
        this.subcategoryId = subcategoryId;
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
