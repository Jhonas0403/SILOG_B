package com.silog.silog_user.application.service.ExpenseCategory;

import com.silog.silog_user.domain.model.ExpenseCategory;
import com.silog.silog_user.domain.port.in.ExpenseCategory.CreateExpenseCategoryUseCase;
import com.silog.silog_user.domain.port.out.ExpenseCategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateExpenseCategoryService implements CreateExpenseCategoryUseCase {
    private final ExpenseCategoryRepositoryPort expenseCategoryRepositoryPort;

    public CreateExpenseCategoryService(ExpenseCategoryRepositoryPort expenseCategoryRepositoryPort) {
        this.expenseCategoryRepositoryPort = expenseCategoryRepositoryPort;
    }

    @Override
    public ExpenseCategory create(ExpenseCategory expenseCategory) {
        if (expenseCategory.getCompanyId() == null) {
            throw new RuntimeException("Expense category company is required");
        }
        if (expenseCategory.getName() == null || expenseCategory.getName().isBlank()) {
            throw new RuntimeException("Expense category name is required");
        }
        if (expenseCategory.getStatus() == null) {
            expenseCategory.setStatus(true);
        }
        if (expenseCategory.getUpdatedBy() == null) {
            expenseCategory.setUpdatedBy(expenseCategory.getCreatedBy());
        }
        expenseCategory.setCreatedAt(LocalDateTime.now());
        expenseCategory.setUpdatedAt(LocalDateTime.now());
        return expenseCategoryRepositoryPort.save(expenseCategory);
    }
}
