package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.ExpenseCategory;

import java.util.List;
import java.util.UUID;

public interface ExpenseCategoryRepositoryPort {
    ExpenseCategory save(ExpenseCategory expenseCategory);
    List<ExpenseCategory> findAll();
    ExpenseCategory findById(UUID id);
}
