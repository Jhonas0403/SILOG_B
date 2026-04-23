package com.silog.silog_user.application.service.InventoryMovement;

import com.silog.silog_user.domain.model.InventoryMovement;
import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.in.InventoryMovement.CreateInventoryMovementUseCase;
import com.silog.silog_user.domain.port.out.InventoryMovementRepositoryPort;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateInventoryMovementService implements CreateInventoryMovementUseCase {
    private static final String MOVEMENT_IN = "IN";
    private static final String MOVEMENT_OUT = "OUT";

    private final InventoryMovementRepositoryPort inventoryMovementRepositoryPort;
    private final VariantRepositoryPort variantRepositoryPort;

    public CreateInventoryMovementService(
            InventoryMovementRepositoryPort inventoryMovementRepositoryPort,
            VariantRepositoryPort variantRepositoryPort
    ) {
        this.inventoryMovementRepositoryPort = inventoryMovementRepositoryPort;
        this.variantRepositoryPort = variantRepositoryPort;
    }

    @Override
    public InventoryMovement create(InventoryMovement inventoryMovement) {
        validate(inventoryMovement);

        Variant variant = variantRepositoryPort.findById(inventoryMovement.getVariantId());
        if (variant == null) {
            throw new RuntimeException("Variant not found");
        }

        int currentStock = variant.getStock() == null ? 0 : variant.getStock();
        int newStock = calculateNewStock(currentStock, inventoryMovement);
        variant.setStock(newStock);
        variant.setUpdatedAt(LocalDateTime.now());
        if (inventoryMovement.getCreatedBy() != null) {
            variant.setUpdatedBy(inventoryMovement.getCreatedBy());
        }
        variantRepositoryPort.save(variant);

        if (inventoryMovement.getStatus() == null) {
            inventoryMovement.setStatus(true);
        }
        if (inventoryMovement.getUpdatedBy() == null) {
            inventoryMovement.setUpdatedBy(inventoryMovement.getCreatedBy());
        }
        inventoryMovement.setCreatedAt(LocalDateTime.now());
        inventoryMovement.setUpdatedAt(LocalDateTime.now());

        return inventoryMovementRepositoryPort.save(inventoryMovement);
    }

    private void validate(InventoryMovement inventoryMovement) {
        if (inventoryMovement.getVariantId() == null) {
            throw new RuntimeException("Variant is required");
        }
        if (inventoryMovement.getQuantity() == null || inventoryMovement.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than zero");
        }
        if (!MOVEMENT_IN.equals(inventoryMovement.getMovementType())
                && !MOVEMENT_OUT.equals(inventoryMovement.getMovementType())) {
            throw new RuntimeException("Movement type must be IN or OUT");
        }
    }

    private int calculateNewStock(int currentStock, InventoryMovement inventoryMovement) {
        if (MOVEMENT_IN.equals(inventoryMovement.getMovementType())) {
            return currentStock + inventoryMovement.getQuantity();
        }

        int newStock = currentStock - inventoryMovement.getQuantity();
        if (newStock < 0) {
            throw new RuntimeException("Insufficient stock");
        }
        return newStock;
    }
}
