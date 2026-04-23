package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.ExpenseCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaExpenseCategoryRepository extends JpaRepository<ExpenseCategoryEntity, UUID> {
    List<ExpenseCategoryEntity> findAllByOrderByNameAsc();
}
