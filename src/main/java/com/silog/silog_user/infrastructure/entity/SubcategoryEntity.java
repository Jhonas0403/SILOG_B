package com.silog.silog_user.infrastructure.entity;

import com.silog.silog_user.domain.model.Subcategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "subcategories")
public class SubcategoryEntity {
    @Id
    @GeneratedValue()
    @Column(name = "subcategory_id", nullable = false,updatable = false)
    private UUID subcategoryId;

    @Column(name = "subcategory_name")
    private String subcategoryName;

    @Column(name = "subcategory_status")
    private Boolean subcategoryStatus;

    @Column (name = "subcategory_order")
    private Integer subcategoryOrder;

    @Column (name = "subcategory_category_id")
    private UUID categoryId;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public SubcategoryEntity() {}

    public UUID getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(UUID subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Boolean getSubcategoryStatus() {
        return subcategoryStatus;
    }

    public void setSubcategoryStatus(Boolean subcategoryStatus) {
        this.subcategoryStatus = subcategoryStatus;
    }

    public Integer getSubcategoryOrder() {
        return subcategoryOrder;
    }

    public void setSubcategoryOrder(Integer subcategoryOrder) {
        this.subcategoryOrder = subcategoryOrder;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
