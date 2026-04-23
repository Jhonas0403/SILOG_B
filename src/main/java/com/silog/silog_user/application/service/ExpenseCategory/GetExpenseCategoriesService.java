package com.silog.silog_user.application.service.ExpenseCategory;

import com.silog.silog_user.domain.model.ExpenseCategory;
import com.silog.silog_user.domain.port.in.ExpenseCategory.GetExpenseCategoriesUseCase;
import com.silog.silog_user.domain.port.out.ExpenseCategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetExpenseCategoriesService implements GetExpenseCategoriesUseCase {
    private final ExpenseCategoryRepositoryPort expenseCategoryRepositoryPort;

    public GetExpenseCategoriesService(ExpenseCategoryRepositoryPort expenseCategoryRepositoryPort) {
        this.expenseCategoryRepositoryPort = expenseCategoryRepositoryPort;
    }

    @Override
    public List<ExpenseCategory> getExpenseCategories() {
        return expenseCategoryRepositoryPort.findAll();
    }
}
