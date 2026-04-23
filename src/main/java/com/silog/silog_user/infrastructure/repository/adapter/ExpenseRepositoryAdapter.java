package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Expense;
import com.silog.silog_user.domain.port.out.ExpenseRepositoryPort;
import com.silog.silog_user.infrastructure.entity.ExpenseEntity;
import com.silog.silog_user.infrastructure.mapper.ExpenseMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaExpenseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ExpenseRepositoryAdapter implements ExpenseRepositoryPort {
    private final JpaExpenseRepository jpaExpenseRepository;

    public ExpenseRepositoryAdapter(JpaExpenseRepository jpaExpenseRepository) {
        this.jpaExpenseRepository = jpaExpenseRepository;
    }

    @Override
    public Expense save(Expense expense) {
        ExpenseEntity entity = ExpenseMapper.toEntity(expense);
        return ExpenseMapper.toDomain(jpaExpenseRepository.save(entity));
    }

    @Override
    public List<Expense> findAll() {
        return jpaExpenseRepository.findAllByOrderByExpenseDateDescCreatedAtDesc()
                .stream()
                .map(ExpenseMapper::toDomain)
                .toList();
    }

    @Override
    public Expense findById(UUID id) {
        return jpaExpenseRepository.findById(id)
                .map(ExpenseMapper::toDomain)
                .orElse(null);
    }
}
