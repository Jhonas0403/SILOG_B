package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Fixes applied:
 * - Added Lombok annotations
 * - Extends AuditableEntity
 * - BUG FIX: 'total' changed from Double to BigDecimal (money must be exact)
 * - Added nullable = false constraints
 */
@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
public class SaleEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sale_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "sale_date")
    private ZonedDateTime saleDate;

    // BUG FIX: was Double — changed to BigDecimal for exact monetary arithmetic
    @Column(name = "total", nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    @Column(name = "sale_status", nullable = false)
    private Boolean status;

    @Column(name = "store_id")
    private UUID storeId;

    @Column(name = "payment_method_id", nullable = false)
    private UUID paymentMethodId;

    @Column(name = "operation_code", length = 100)
    private String operationCode;
}
