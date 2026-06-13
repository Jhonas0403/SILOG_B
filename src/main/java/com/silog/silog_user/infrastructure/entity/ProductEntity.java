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
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "product_name", nullable = false, length = 150)
    private String productName;

    @Column(name = "product_brand_id")
    private UUID productBrandId;

    @Column(name = "product_status", nullable = false)
    private Boolean productStatus;

    @Column(name = "product_order")
    private Integer productOrder;

    @Column(name = "store_id")
    private UUID storeId;
}
