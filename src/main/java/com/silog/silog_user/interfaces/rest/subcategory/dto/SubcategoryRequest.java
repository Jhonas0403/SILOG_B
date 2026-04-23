package com.silog.silog_user.interfaces.rest.subcategory.dto;

import com.silog.silog_user.domain.model.Subcategory;

import java.util.UUID;

public class SubcategoryRequest {
    private String name;
    private Boolean status;
    private UUID categoryId;
    private UUID createdBy;

    public Subcategory toDomain() {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(name);
        subcategory.setStatus(status);
        subcategory.setCategoryId(categoryId);
        subcategory.setCreatedBy(createdBy);
        return subcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }
}
