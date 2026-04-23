package com.silog.silog_user.domain.port.in.Expense;

import com.silog.silog_user.domain.model.Expense;

import java.util.UUID;

public interface GetExpenseByIdUseCase {
    Expense getExpenseById(UUID id);
}
