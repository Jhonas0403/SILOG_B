package com.silog.silog_user.interfaces.rest.category.dto;

import com.silog.silog_user.domain.model.Category;

import java.util.UUID;

public class CategoryRequest {
    private String name;
    private Boolean status;
    private UUID createdBy;

    public Category toDomain() {
        Category category = new Category();
        category.setName(name);
        category.setStatus(status);
        category.setCreatedBy(createdBy);
        return category;
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

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }
}
