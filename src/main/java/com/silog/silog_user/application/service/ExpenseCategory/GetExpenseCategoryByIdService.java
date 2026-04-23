package com.silog.silog_user.application.service.ExpenseCategory;

import com.silog.silog_user.domain.model.ExpenseCategory;
import com.silog.silog_user.domain.port.in.ExpenseCategory.GetExpenseCategoryByIdUseCase;
import com.silog.silog_user.domain.port.out.ExpenseCategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetExpenseCategoryByIdService implements GetExpenseCategoryByIdUseCase {
    private final ExpenseCategoryRepositoryPort expenseCategoryRepositoryPort;

    public GetExpenseCategoryByIdService(ExpenseCategoryRepositoryPort expenseCategoryRepositoryPort) {
        this.expenseCategoryRepositoryPort = expenseCategoryRepositoryPort;
    }

    @Override
    public ExpenseCategory getExpenseCategoryById(UUID id) {
        return expenseCategoryRepositoryPort.findById(id);
    }
}
