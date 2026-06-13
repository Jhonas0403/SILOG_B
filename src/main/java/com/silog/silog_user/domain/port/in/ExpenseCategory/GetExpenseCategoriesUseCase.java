package com.silog.silog_user.domain.port.in.ExpenseCategory;

import com.silog.silog_user.domain.model.ExpenseCategory;

import java.util.List;
import java.util.UUID;

public interface GetExpenseCategoriesUseCase {
    List<ExpenseCategory> getExpenseCategories(UUID storeId);
}
