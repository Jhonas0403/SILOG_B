package com.silog.silog_user.domain.port.in.InventoryMovement;

import com.silog.silog_user.domain.model.InventoryMovement;

public interface CreateInventoryMovementUseCase {
    InventoryMovement create(InventoryMovement inventoryMovement);
}
