package com.silog.silog_user.application.service.InventoryMovement;

import com.silog.silog_user.domain.model.InventoryMovement;
import com.silog.silog_user.domain.port.in.InventoryMovement.GetInventoryMovementByIdUseCase;
import com.silog.silog_user.domain.port.out.InventoryMovementRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetInventoryMovementByIdService implements GetInventoryMovementByIdUseCase {
    private final InventoryMovementRepositoryPort inventoryMovementRepositoryPort;

    public GetInventoryMovementByIdService(InventoryMovementRepositoryPort inventoryMovementRepositoryPort) {
        this.inventoryMovementRepositoryPort = inventoryMovementRepositoryPort;
    }

    @Override
    public InventoryMovement getInventoryMovementById(UUID id) {
        return inventoryMovementRepositoryPort.findById(id);
    }
}
