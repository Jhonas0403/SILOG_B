package com.silog.silog_user.domain.port.in.ExpenseCategory;

import com.silog.silog_user.domain.model.ExpenseCategory;

import java.util.UUID;

public interface GetExpenseCategoryByIdUseCase {
    ExpenseCategory getExpenseCategoryById(UUID id);
}
