package com.silog.silog_user.application.service.InventoryMovement;

import com.silog.silog_user.domain.model.InventoryMovement;
import com.silog.silog_user.domain.port.in.InventoryMovement.GetInventoryMovementsUseCase;
import com.silog.silog_user.domain.port.out.InventoryMovementRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetInventoryMovementsService implements GetInventoryMovementsUseCase {
    private final InventoryMovementRepositoryPort inventoryMovementRepositoryPort;

    public GetInventoryMovementsService(InventoryMovementRepositoryPort inventoryMovementRepositoryPort) {
        this.inventoryMovementRepositoryPort = inventoryMovementRepositoryPort;
    }

    @Override
    public List<InventoryMovement> getInventoryMovements(UUID storeId) {
        if (storeId != null) return inventoryMovementRepositoryPort.findByStoreId(storeId);
        return inventoryMovementRepositoryPort.findAll();
    }
}
