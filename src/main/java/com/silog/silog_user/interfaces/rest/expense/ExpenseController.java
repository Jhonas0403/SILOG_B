package com.silog.silog_user.interfaces.rest.expense;

import com.silog.silog_user.domain.model.Expense;
import com.silog.silog_user.domain.port.in.Expense.CreateExpenseUseCase;
import com.silog.silog_user.domain.port.in.Expense.GetExpenseByIdUseCase;
import com.silog.silog_user.domain.port.in.Expense.GetExpensesUseCase;
import com.silog.silog_user.interfaces.rest.expense.dto.ExpenseRequest;
import com.silog.silog_user.interfaces.rest.expense.dto.ExpenseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final CreateExpenseUseCase createExpenseUseCase;
    private final GetExpensesUseCase getExpensesUseCase;
    private final GetExpenseByIdUseCase getExpenseByIdUseCase;

    public ExpenseController(
            CreateExpenseUseCase createExpenseUseCase,
            GetExpensesUseCase getExpensesUseCase,
            GetExpenseByIdUseCase getExpenseByIdUseCase
    ) {
        this.createExpenseUseCase = createExpenseUseCase;
        this.getExpensesUseCase = getExpensesUseCase;
        this.getExpenseByIdUseCase = getExpenseByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getExpenses() {
        List<Expense> expenses = getExpensesUseCase.getExpenses();
        return ResponseEntity.ok(expenses.stream().map(ExpenseResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getExpenseById(@PathVariable UUID id) {
        Expense expense = getExpenseByIdUseCase.getExpenseById(id);
        return ResponseEntity.ok(ExpenseResponse.fromDomain(expense));
    }

    @PostMapping
    public ResponseEntity<ExpenseResponse> createExpense(@RequestBody ExpenseRequest expense) {
        Expense created = createExpenseUseCase.create(expense.toDomain());
        return ResponseEntity.ok(ExpenseResponse.fromDomain(created));
    }
}
