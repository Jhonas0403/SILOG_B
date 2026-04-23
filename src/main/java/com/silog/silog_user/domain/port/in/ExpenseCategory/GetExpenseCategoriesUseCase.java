package com.silog.silog_user.domain.port.in.ExpenseCategory;

import com.silog.silog_user.domain.model.ExpenseCategory;

import java.util.List;

public interface GetExpenseCategoriesUseCase {
    List<ExpenseCategory> getExpenseCategories();
}
