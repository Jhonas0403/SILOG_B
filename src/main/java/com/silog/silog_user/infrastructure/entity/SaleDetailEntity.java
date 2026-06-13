package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Fixes applied:
 * - Added Lombok annotations
 * - Extends AuditableEntity
 * - BUG FIX: salePrice, purchasePrice, subtotal changed from Double to BigDecimal
 * - Added nullable = false and precision constraints
 */
@Entity
@Table(name = "sale_details")
@Getter
@Setter
@NoArgsConstructor
public class SaleDetailEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sale_detail_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "sale_id", nullable = false)
    private UUID saleId;

    @Column(name = "variant_id", nullable = false)
    private UUID variantId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // BUG FIX: was Double — changed to BigDecimal
    @Column(name = "sale_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal salePrice;

    @Column(name = "purchase_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal purchasePrice;

    @Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "sale_detail_status", nullable = false)
    private Boolean status;
}
