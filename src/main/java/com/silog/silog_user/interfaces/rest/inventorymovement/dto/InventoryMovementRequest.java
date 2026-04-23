package com.silog.silog_user.interfaces.rest.inventorymovement.dto;

import com.silog.silog_user.domain.model.InventoryMovement;

import java.util.UUID;

public class InventoryMovementRequest {
    private UUID variantId;
    private String movementType;
    private Integer quantity;
    private Double purchasePrice;
    private Double salePrice;
    private String referenceType;
    private UUID referenceId;
    private UUID createdBy;

    public InventoryMovement toDomain() {
        InventoryMovement inventoryMovement = new InventoryMovement();
        inventoryMovement.setVariantId(variantId);
        inventoryMovement.setMovementType(movementType);
        inventoryMovement.setQuantity(quantity);
        inventoryMovement.setPurchasePrice(purchasePrice);
        inventoryMovement.setSalePrice(salePrice);
        inventoryMovement.setReferenceType(referenceType);
        inventoryMovement.setReferenceId(referenceId);
        inventoryMovement.setCreatedBy(createdBy);
        return inventoryMovement;
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

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }
}
