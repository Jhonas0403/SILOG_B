package com.silog.silog_user.interfaces.rest.expensecategory.dto;

import com.silog.silog_user.domain.model.ExpenseCategory;

import java.time.LocalDateTime;
import java.util.UUID;

public class ExpenseCategoryResponse {
    private UUID id;
    private UUID companyId;
    private String name;
    private String description;
    private Boolean status;
    private UUID createdBy;
    private UUID updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ExpenseCategoryResponse fromDomain(ExpenseCategory expenseCategory) {
        if (expenseCategory == null) {
            return null;
        }
        ExpenseCategoryResponse response = new ExpenseCategoryResponse();
        response.setId(expenseCategory.getId());
        response.setCompanyId(expenseCategory.getCompanyId());
        response.setName(expenseCategory.getName());
        response.setDescription(expenseCategory.getDescription());
        response.setStatus(expenseCategory.getStatus());
        response.setCreatedBy(expenseCategory.getCreatedBy());
        response.setUpdatedBy(expenseCategory.getUpdatedBy());
        response.setCreatedAt(expenseCategory.getCreatedAt());
        response.setUpdatedAt(expenseCategory.getUpdatedAt());
        return response;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
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
