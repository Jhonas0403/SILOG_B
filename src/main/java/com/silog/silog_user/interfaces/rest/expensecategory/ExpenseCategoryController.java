package com.silog.silog_user.interfaces.rest.expensecategory;

import com.silog.silog_user.domain.model.ExpenseCategory;
import com.silog.silog_user.domain.port.in.ExpenseCategory.CreateExpenseCategoryUseCase;
import com.silog.silog_user.domain.port.in.ExpenseCategory.GetExpenseCategoriesUseCase;
import com.silog.silog_user.domain.port.in.ExpenseCategory.GetExpenseCategoryByIdUseCase;
import com.silog.silog_user.interfaces.rest.expensecategory.dto.ExpenseCategoryRequest;
import com.silog.silog_user.interfaces.rest.expensecategory.dto.ExpenseCategoryResponse;
import org.springframework.http.ResponseEntity;
import com.silog.silog_user.infrastructure.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        UUID storeId = getStoreIdFromJwt();
        List<ExpenseCategory> expenseCategories = getExpenseCategoriesUseCase.getExpenseCategories(storeId);
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
        ExpenseCategory dom = expenseCategory.toDomain();
        dom.setStoreId(getStoreIdFromJwt());
        ExpenseCategory created = createExpenseCategoryUseCase.create(dom);
        return ResponseEntity.ok(ExpenseCategoryResponse.fromDomain(created));
    }

    private UUID getStoreIdFromJwt() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        return principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
    }
}
