package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.InventoryMovement;
import com.silog.silog_user.infrastructure.entity.InventoryMovementEntity;

public class InventoryMovementMapper {
    public static InventoryMovementEntity toEntity(InventoryMovement inventoryMovement) {
        InventoryMovementEntity entity = new InventoryMovementEntity();
        entity.setId(inventoryMovement.getId());
        entity.setStoreId(inventoryMovement.getStoreId());
        entity.setVariantId(inventoryMovement.getVariantId());
        entity.setMovementType(inventoryMovement.getMovementType());
        entity.setQuantity(inventoryMovement.getQuantity());
        entity.setPurchasePrice(inventoryMovement.getPurchasePrice());
        entity.setSalePrice(inventoryMovement.getSalePrice());
        entity.setReferenceType(inventoryMovement.getReferenceType());
        entity.setReferenceId(inventoryMovement.getReferenceId());
        entity.setStatus(inventoryMovement.getStatus());
        // Note: audit fields handled automatically by AuditingEntityListener
        return entity;
    }

    public static InventoryMovement toDomain(InventoryMovementEntity entity) {
        if (entity == null) {
            return null;
        }
        InventoryMovement inventoryMovement = new InventoryMovement();
        inventoryMovement.setId(entity.getId());
        inventoryMovement.setStoreId(entity.getStoreId());
        inventoryMovement.setVariantId(entity.getVariantId());
        inventoryMovement.setMovementType(entity.getMovementType());
        inventoryMovement.setQuantity(entity.getQuantity());
        inventoryMovement.setPurchasePrice(entity.getPurchasePrice());
        inventoryMovement.setSalePrice(entity.getSalePrice());
        inventoryMovement.setReferenceType(entity.getReferenceType());
        inventoryMovement.setReferenceId(entity.getReferenceId());
        inventoryMovement.setStatus(entity.getStatus());
        inventoryMovement.setCreatedBy(entity.getCreatedBy());
        inventoryMovement.setUpdatedBy(entity.getUpdatedBy());
        inventoryMovement.setCreatedAt(entity.getCreatedAt());
        inventoryMovement.setUpdatedAt(entity.getUpdatedAt());
        return inventoryMovement;
    }
}
