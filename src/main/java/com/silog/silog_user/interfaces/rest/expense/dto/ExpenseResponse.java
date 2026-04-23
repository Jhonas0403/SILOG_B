package com.silog.silog_user.interfaces.rest.expense.dto;

import com.silog.silog_user.domain.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExpenseResponse {
    private UUID id;
    private UUID companyId;
    private UUID storeId;
    private UUID expenseCategoryId;
    private String description;
    private BigDecimal amount;
    private LocalDate expenseDate;
    private Boolean status;
    private UUID createdBy;
    private UUID updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ExpenseResponse fromDomain(Expense expense) {
        if (expense == null) {
            return null;
        }
        ExpenseResponse response = new ExpenseResponse();
        response.setId(expense.getId());
        response.setCompanyId(expense.getCompanyId());
        response.setStoreId(expense.getStoreId());
        response.setExpenseCategoryId(expense.getExpenseCategoryId());
        response.setDescription(expense.getDescription());
        response.setAmount(expense.getAmount());
        response.setExpenseDate(expense.getExpenseDate());
        response.setStatus(expense.getStatus());
        response.setCreatedBy(expense.getCreatedBy());
        response.setUpdatedBy(expense.getUpdatedBy());
        response.setCreatedAt(expense.getCreatedAt());
        response.setUpdatedAt(expense.getUpdatedAt());
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

    public UUID getStoreId() {
        return storeId;
    }

    public void setStoreId(UUID storeId) {
        this.storeId = storeId;
    }

    public UUID getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(UUID expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
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
