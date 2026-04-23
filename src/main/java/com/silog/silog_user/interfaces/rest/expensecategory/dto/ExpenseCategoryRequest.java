package com.silog.silog_user.interfaces.rest.expensecategory.dto;

import com.silog.silog_user.domain.model.ExpenseCategory;

import java.util.UUID;

public class ExpenseCategoryRequest {
    private UUID companyId;
    private String name;
    private String description;
    private Boolean status;
    private UUID createdBy;

    public ExpenseCategory toDomain() {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setCompanyId(companyId);
        expenseCategory.setName(name);
        expenseCategory.setDescription(description);
        expenseCategory.setStatus(status);
        expenseCategory.setCreatedBy(createdBy);
        return expenseCategory;
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
}
