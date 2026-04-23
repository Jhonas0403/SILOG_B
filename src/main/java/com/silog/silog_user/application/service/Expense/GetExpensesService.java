package com.silog.silog_user.application.service.Expense;

import com.silog.silog_user.domain.model.Expense;
import com.silog.silog_user.domain.port.in.Expense.GetExpensesUseCase;
import com.silog.silog_user.domain.port.out.ExpenseRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetExpensesService implements GetExpensesUseCase {
    private final ExpenseRepositoryPort expenseRepositoryPort;

    public GetExpensesService(ExpenseRepositoryPort expenseRepositoryPort) {
        this.expenseRepositoryPort = expenseRepositoryPort;
    }

    @Override
    public List<Expense> getExpenses() {
        return expenseRepositoryPort.findAll();
    }
}
