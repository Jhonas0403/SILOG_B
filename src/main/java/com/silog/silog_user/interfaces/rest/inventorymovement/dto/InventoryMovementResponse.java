package com.silog.silog_user.interfaces.rest.inventorymovement.dto;

import com.silog.silog_user.domain.model.InventoryMovement;

import java.time.LocalDateTime;
import java.util.UUID;

public class InventoryMovementResponse {
    private UUID id;
    private UUID variantId;
    private String movementType;
    private Integer quantity;
    private Double purchasePrice;
    private Double salePrice;
    private String referenceType;
    private UUID referenceId;
    private Boolean status;
    private UUID createdBy;
    private UUID updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static InventoryMovementResponse fromDomain(InventoryMovement inventoryMovement) {
        if (inventoryMovement == null) {
            return null;
        }
        InventoryMovementResponse response = new InventoryMovementResponse();
        response.setId(inventoryMovement.getId());
        response.setVariantId(inventoryMovement.getVariantId());
        response.setMovementType(inventoryMovement.getMovementType());
        response.setQuantity(inventoryMovement.getQuantity());
        response.setPurchasePrice(inventoryMovement.getPurchasePrice());
        response.setSalePrice(inventoryMovement.getSalePrice());
        response.setReferenceType(inventoryMovement.getReferenceType());
        response.setReferenceId(inventoryMovement.getReferenceId());
        response.setStatus(inventoryMovement.getStatus());
        response.setCreatedBy(inventoryMovement.getCreatedBy());
        response.setUpdatedBy(inventoryMovement.getUpdatedBy());
        response.setCreatedAt(inventoryMovement.getCreatedAt());
        response.setUpdatedAt(inventoryMovement.getUpdatedAt());
        return response;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVariantId() {
        return variantId;
    }

    public void setVariantId(UUID variantId) {
        this.variantId = variantId;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public UUID getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(UUID referenceId) {
        this.referenceId = referenceId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
