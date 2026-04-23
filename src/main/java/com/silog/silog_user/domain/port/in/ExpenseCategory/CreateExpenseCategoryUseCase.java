package com.silog.silog_user.domain.port.in.ExpenseCategory;

import com.silog.silog_user.domain.model.ExpenseCategory;

public interface CreateExpenseCategoryUseCase {
    ExpenseCategory create(ExpenseCategory expenseCategory);
}
