package com.silog.silog_user.interfaces.rest.subcategory.dto;

import com.silog.silog_user.domain.model.Subcategory;

import java.time.LocalDateTime;
import java.util.UUID;

public class SubcategoryResponse {
    private UUID id;
    private String name;
    private Integer order;
    private Boolean status;
    private UUID categoryId;
    private UUID createdBy;
    private UUID updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static SubcategoryResponse fromDomain(Subcategory subcategory) {
        if (subcategory == null) {
            return null;
        }
        SubcategoryResponse response = new SubcategoryResponse();
        response.setId(subcategory.getId());
        response.setName(subcategory.getName());
        response.setOrder(subcategory.getOrder());
        response.setStatus(subcategory.getStatus());
        response.setCategoryId(subcategory.getCategoryId());
        response.setCreatedBy(subcategory.getCreatedBy());
        response.setUpdatedBy(subcategory.getUpdatedBy());
        response.setCreatedAt(subcategory.getCreatedAt());
        response.setUpdatedAt(subcategory.getUpdatedAt());
        return response;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
