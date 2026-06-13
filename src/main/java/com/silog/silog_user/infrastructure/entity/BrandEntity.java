package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Fixes applied:
 * - Added Lombok annotations
 * - Extends AuditableEntity
 * - BUG FIX: field was named 'categoryStatus' (mapped to brand_status column) — renamed to 'brandStatus'
 *   The old getter getCategoryStatus() was causing confusion with CategoryEntity
 * - Added nullable = false and length constraints
 */
@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
public class BrandEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "brand_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "brand_name", nullable = false, length = 100)
    private String brandName;

    @Column(name = "brand_description", length = 255)
    private String brandDescription;

    @Column(name = "brand_subcategory_id")
    private UUID brandSubcategoryId;

    // BUG FIX: was 'categoryStatus' — renamed to 'brandStatus' (matches column brand_status)
    @Column(name = "brand_status", nullable = false)
    private Boolean brandStatus;

    @Column(name = "brand_order")
    private Integer brandOrder;

    @Column(name = "store_id")
    private UUID storeId;
}
