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
 * - Added nullable = false and length constraints
 */
@Entity
@Table(name = "subcategories")
@Getter
@Setter
@NoArgsConstructor
public class SubcategoryEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subcategory_id", nullable = false, updatable = false)
    private UUID subcategoryId;

    @Column(name = "subcategory_name", nullable = false, length = 100)
    private String subcategoryName;

    @Column(name = "subcategory_status", nullable = false)
    private Boolean subcategoryStatus;

    @Column(name = "subcategory_order")
    private Integer subcategoryOrder;

    @Column(name = "subcategory_category_id")
    private UUID categoryId;

    @Column(name = "store_id")
    private UUID storeId;
}
