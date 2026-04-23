package com.silog.silog_user.interfaces.rest.expensecategory;

import com.silog.silog_user.domain.model.ExpenseCategory;
import com.silog.silog_user.domain.port.in.ExpenseCategory.CreateExpenseCategoryUseCase;
import com.silog.silog_user.domain.port.in.ExpenseCategory.GetExpenseCategoriesUseCase;
import com.silog.silog_user.domain.port.in.ExpenseCategory.GetExpenseCategoryByIdUseCase;
import com.silog.silog_user.interfaces.rest.expensecategory.dto.ExpenseCategoryRequest;
import com.silog.silog_user.interfaces.rest.expensecategory.dto.ExpenseCategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expense-categories")
public class ExpenseCategoryController {
    private final CreateExpenseCategoryUseCase createExpenseCategoryUseCase;
    private final GetExpenseCategoriesUseCase getExpenseCategoriesUseCase;
    private final GetExpenseCategoryByIdUseCase getExpenseCategoryByIdUseCase;

    public ExpenseCategoryController(
            CreateExpenseCategoryUseCase createExpenseCategoryUseCase,
            GetExpenseCategoriesUseCase getExpenseCategoriesUseCase,
            GetExpenseCategoryByIdUseCase getExpenseCategoryByIdUseCase
    ) {
        this.createExpenseCategoryUseCase = createExpenseCategoryUseCase;
        this.getExpenseCategoriesUseCase = getExpenseCategoriesUseCase;
        this.getExpenseCategoryByIdUseCase = getExpenseCategoryByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ExpenseCategoryResponse>> getExpenseCategories() {
        List<ExpenseCategory> expenseCategories = getExpenseCategoriesUseCase.getExpenseCategories();
        return ResponseEntity.ok(expenseCategories.stream().map(ExpenseCategoryResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseCategoryResponse> getExpenseCategoryById(@PathVariable UUID id) {
        ExpenseCategory expenseCategory = getExpenseCategoryByIdUseCase.getExpenseCategoryById(id);
        return ResponseEntity.ok(ExpenseCategoryResponse.fromDomain(expenseCategory));
    }

    @PostMapping
    public ResponseEntity<ExpenseCategoryResponse> createExpenseCategory(
            @RequestBody ExpenseCategoryRequest expenseCategory
    ) {
        ExpenseCategory created = createExpenseCategoryUseCase.create(expenseCategory.toDomain());
        return ResponseEntity.ok(ExpenseCategoryResponse.fromDomain(created));
    }
}
