package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.InventoryMovement;

import java.util.List;
import java.util.UUID;

public interface InventoryMovementRepositoryPort {
    InventoryMovement save(InventoryMovement inventoryMovement);
    List<InventoryMovement> findAll();
    InventoryMovement findById(UUID id);
}
