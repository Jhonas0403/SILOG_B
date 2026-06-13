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
 * - BUG FIX: purchasePrice and salePrice changed from Double to BigDecimal
 * - Added nullable = false and length constraints on movement_type and reference_type
 */
@Entity
@Table(name = "inventory_movements")
@Getter
@Setter
@NoArgsConstructor
public class InventoryMovementEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "movement_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "variant_id", nullable = false)
    private UUID variantId;

    // Values must be 'IN' or 'OUT' — enforced by CHECK constraint in migration script
    @Column(name = "movement_type", nullable = false, length = 10)
    private String movementType;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // BUG FIX: was Double — changed to BigDecimal
    @Column(name = "purchase_price", precision = 12, scale = 2)
    private BigDecimal purchasePrice;

    @Column(name = "sale_price", precision = 12, scale = 2)
    private BigDecimal salePrice;

    // Values must be 'PURCHASE' or 'SALE' — enforced by CHECK constraint
    @Column(name = "reference_type", length = 20)
    private String referenceType;

    @Column(name = "reference_id")
    private UUID referenceId;

    @Column(name = "movement_status", nullable = false)
    private Boolean status;

    @Column(name = "store_id")
    private UUID storeId;
}
