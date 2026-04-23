package com.silog.silog_user.domain.port.in.InventoryMovement;

import com.silog.silog_user.domain.model.InventoryMovement;

import java.util.List;

public interface GetInventoryMovementsUseCase {
    List<InventoryMovement> getInventoryMovements();
}
