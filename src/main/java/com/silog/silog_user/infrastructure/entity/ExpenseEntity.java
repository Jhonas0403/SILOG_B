package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Fixes applied:
 * - Added Lombok annotations
 * - Extends AuditableEntity
 * - 'amount' already was BigDecimal (correct!) — kept as is
 * - Added nullable = false constraints
 */
@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
public class ExpenseEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "expense_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;

    @Column(name = "store_id")
    private UUID storeId;

    @Column(name = "expense_category_id", nullable = false)
    private UUID expenseCategoryId;

    @Column(name = "expense_description", length = 255)
    private String description;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "expense_date", nullable = false)
    private LocalDate expenseDate;

    @Column(name = "expense_status", nullable = false)
    private Boolean status;
}
