package com.silog.silog_user.interfaces.rest.expense.dto;

import com.silog.silog_user.domain.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ExpenseRequest {
    private UUID companyId;
    private UUID storeId;
    private UUID expenseCategoryId;
    private String description;
    private BigDecimal amount;
    private LocalDate expenseDate;
    private Boolean status;
    private UUID createdBy;

    public Expense toDomain() {
        Expense expense = new Expense();
        expense.setCompanyId(companyId);
        expense.setStoreId(storeId);
        expense.setExpenseCategoryId(expenseCategoryId);
        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setExpenseDate(expenseDate);
        expense.setStatus(status);
        expense.setCreatedBy(createdBy);
        return expense;
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
}
