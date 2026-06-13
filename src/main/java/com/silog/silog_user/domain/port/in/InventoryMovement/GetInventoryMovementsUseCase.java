package com.silog.silog_user.domain.port.in.InventoryMovement;

import com.silog.silog_user.domain.model.InventoryMovement;

import java.util.List;
import java.util.UUID;

public interface GetInventoryMovementsUseCase {
    List<InventoryMovement> getInventoryMovements(UUID storeId);
}
