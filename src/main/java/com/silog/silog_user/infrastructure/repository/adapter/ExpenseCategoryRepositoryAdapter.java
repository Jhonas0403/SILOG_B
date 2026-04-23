package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.ExpenseCategory;
import com.silog.silog_user.domain.port.out.ExpenseCategoryRepositoryPort;
import com.silog.silog_user.infrastructure.entity.ExpenseCategoryEntity;
import com.silog.silog_user.infrastructure.mapper.ExpenseCategoryMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaExpenseCategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ExpenseCategoryRepositoryAdapter implements ExpenseCategoryRepositoryPort {
    private final JpaExpenseCategoryRepository jpaExpenseCategoryRepository;

    public ExpenseCategoryRepositoryAdapter(JpaExpenseCategoryRepository jpaExpenseCategoryRepository) {
        this.jpaExpenseCategoryRepository = jpaExpenseCategoryRepository;
    }

    @Override
    public ExpenseCategory save(ExpenseCategory expenseCategory) {
        ExpenseCategoryEntity entity = ExpenseCategoryMapper.toEntity(expenseCategory);
        return ExpenseCategoryMapper.toDomain(jpaExpenseCategoryRepository.save(entity));
    }

    @Override
    public List<ExpenseCategory> findAll() {
        return jpaExpenseCategoryRepository.findAllByOrderByNameAsc()
                .stream()
                .map(ExpenseCategoryMapper::toDomain)
                .toList();
    }

    @Override
    public ExpenseCategory findById(UUID id) {
        return jpaExpenseCategoryRepository.findById(id)
                .map(ExpenseCategoryMapper::toDomain)
                .orElse(null);
    }
}
