package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Expense;

import java.util.List;
import java.util.UUID;

public interface ExpenseRepositoryPort {
    Expense save(Expense expense);
    List<Expense> findAll();
    Expense findById(UUID id);
}
