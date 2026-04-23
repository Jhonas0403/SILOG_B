package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.ExpenseCategory;
import com.silog.silog_user.infrastructure.entity.ExpenseCategoryEntity;

public class ExpenseCategoryMapper {
    public static ExpenseCategoryEntity toEntity(ExpenseCategory expenseCategory) {
        ExpenseCategoryEntity entity = new ExpenseCategoryEntity();
        entity.setId(expenseCategory.getId());
        entity.setCompanyId(expenseCategory.getCompanyId());
        entity.setName(expenseCategory.getName());
        entity.setDescription(expenseCategory.getDescription());
        entity.setStatus(expenseCategory.getStatus());
        entity.setCreatedBy(expenseCategory.getCreatedBy());
        entity.setUpdatedBy(expenseCategory.getUpdatedBy());
        entity.setCreatedAt(expenseCategory.getCreatedAt());
        entity.setUpdatedAt(expenseCategory.getUpdatedAt());
        return entity;
    }

    public static ExpenseCategory toDomain(ExpenseCategoryEntity entity) {
        if (entity == null) {
            return null;
        }
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setId(entity.getId());
        expenseCategory.setCompanyId(entity.getCompanyId());
        expenseCategory.setName(entity.getName());
        expenseCategory.setDescription(entity.getDescription());
        expenseCategory.setStatus(entity.getStatus());
        expenseCategory.setCreatedBy(entity.getCreatedBy());
        expenseCategory.setUpdatedBy(entity.getUpdatedBy());
        expenseCategory.setCreatedAt(entity.getCreatedAt());
        expenseCategory.setUpdatedAt(entity.getUpdatedAt());
        return expenseCategory;
    }
}
