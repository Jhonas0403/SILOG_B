package com.silog.silog_user.application.service.Expense;

import com.silog.silog_user.domain.model.Expense;
import com.silog.silog_user.domain.port.in.Expense.CreateExpenseUseCase;
import com.silog.silog_user.domain.port.out.ExpenseRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CreateExpenseService implements CreateExpenseUseCase {
    private final ExpenseRepositoryPort expenseRepositoryPort;

    public CreateExpenseService(ExpenseRepositoryPort expenseRepositoryPort) {
        this.expenseRepositoryPort = expenseRepositoryPort;
    }

    @Override
    public Expense create(Expense expense) {
        if (expense.getCompanyId() == null) {
            throw new RuntimeException("Expense company is required");
        }
        if (expense.getExpenseCategoryId() == null) {
            throw new RuntimeException("Expense category is required");
        }
        if (expense.getAmount() == null || expense.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Expense amount must be greater than zero");
        }
        if (expense.getExpenseDate() == null) {
            throw new RuntimeException("Expense date is required");
        }
        if (expense.getStatus() == null) {
            expense.setStatus(true);
        }
        if (expense.getUpdatedBy() == null) {
            expense.setUpdatedBy(expense.getCreatedBy());
        }
        expense.setCreatedAt(LocalDateTime.now());
        expense.setUpdatedAt(LocalDateTime.now());
        return expenseRepositoryPort.save(expense);
    }
}
