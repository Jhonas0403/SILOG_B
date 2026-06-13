package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Fixes applied:
 * - Added Lombok annotations — removes ~65 lines of manual code
 * - Extends AuditableEntity — audit fields now managed automatically
 * - Added nullable = false and length constraints
 */
@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "category_name", nullable = false, length = 100)
    private String categoryName;

    @Column(name = "category_status", nullable = false)
    private Boolean categoryStatus;

    @Column(name = "category_order")
    private Integer categoryOrder;

    @Column(name = "store_id")
    private UUID storeId;
}
