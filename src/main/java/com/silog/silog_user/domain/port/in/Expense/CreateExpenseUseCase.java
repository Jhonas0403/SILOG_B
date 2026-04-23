package com.silog.silog_user.domain.port.in.Expense;

import com.silog.silog_user.domain.model.Expense;

public interface CreateExpenseUseCase {
    Expense create(Expense expense);
}
