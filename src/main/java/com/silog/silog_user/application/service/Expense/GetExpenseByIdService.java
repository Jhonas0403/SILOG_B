package com.silog.silog_user.application.service.Expense;

import com.silog.silog_user.domain.model.Expense;
import com.silog.silog_user.domain.port.in.Expense.GetExpenseByIdUseCase;
import com.silog.silog_user.domain.port.out.ExpenseRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetExpenseByIdService implements GetExpenseByIdUseCase {
    private final ExpenseRepositoryPort expenseRepositoryPort;

    public GetExpenseByIdService(ExpenseRepositoryPort expenseRepositoryPort) {
        this.expenseRepositoryPort = expenseRepositoryPort;
    }

    @Override
    public Expense getExpenseById(UUID id) {
        return expenseRepositoryPort.findById(id);
    }
}
