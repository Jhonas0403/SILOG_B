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
 * - BUG FIX: variantPurchasePrice, variantSalePrice, variantMinSalePrice changed from Double to BigDecimal
 *   Reason: Double causes floating-point rounding errors with money (e.g. 0.1 + 0.2 = 0.30000000000000004)
 *   BigDecimal is exact and is the standard for financial amounts
 * - Added nullable = false and length/precision constraints
 */
@Entity
@Table(name = "product_variants")
@Getter
@Setter
@NoArgsConstructor
public class VariantEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "variant_id", nullable = false, updatable = false)
    private UUID variantId;

    @Column(name = "variant_product_id", nullable = false)
    private UUID variantProductId;

    @Column(name = "variant_name", nullable = false, length = 150)
    private String variantName;

    @Column(name = "variant_barcode", unique = true, length = 100)
    private String variantBarcode;

    @Column(name = "variant_stock", nullable = false)
    private Integer variantStock;

    // BUG FIX: was Double — changed to BigDecimal for exact monetary arithmetic
    @Column(name = "variant_purchase_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal variantPurchasePrice;

    @Column(name = "variant_sale_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal variantSalePrice;

    @Column(name = "variant_min_sale_price", precision = 12, scale = 2)
    private BigDecimal variantMinSalePrice;

    @Column(name = "variant_order")
    private Integer variantOrder;

    @Column(name = "variant_status", nullable = false)
    private Boolean variantStatus;

    @Column(name = "store_id")
    private UUID storeId;
}
