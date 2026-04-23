package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Expense;
import com.silog.silog_user.infrastructure.entity.ExpenseEntity;

public class ExpenseMapper {
    public static ExpenseEntity toEntity(Expense expense) {
        ExpenseEntity entity = new ExpenseEntity();
        entity.setId(expense.getId());
        entity.setCompanyId(expense.getCompanyId());
        entity.setStoreId(expense.getStoreId());
        entity.setExpenseCategoryId(expense.getExpenseCategoryId());
        entity.setDescription(expense.getDescription());
        entity.setAmount(expense.getAmount());
        entity.setExpenseDate(expense.getExpenseDate());
        entity.setStatus(expense.getStatus());
        entity.setCreatedBy(expense.getCreatedBy());
        entity.setUpdatedBy(expense.getUpdatedBy());
        entity.setCreatedAt(expense.getCreatedAt());
        entity.setUpdatedAt(expense.getUpdatedAt());
        return entity;
    }

    public static Expense toDomain(ExpenseEntity entity) {
        if (entity == null) {
            return null;
        }
        Expense expense = new Expense();
        expense.setId(entity.getId());
        expense.setCompanyId(entity.getCompanyId());
        expense.setStoreId(entity.getStoreId());
        expense.setExpenseCategoryId(entity.getExpenseCategoryId());
        expense.setDescription(entity.getDescription());
        expense.setAmount(entity.getAmount());
        expense.setExpenseDate(entity.getExpenseDate());
        expense.setStatus(entity.getStatus());
        expense.setCreatedBy(entity.getCreatedBy());
        expense.setUpdatedBy(entity.getUpdatedBy());
        expense.setCreatedAt(entity.getCreatedAt());
        expense.setUpdatedAt(entity.getUpdatedAt());
        return expense;
    }
}
