package com.silog.silog_user.interfaces.rest.inventorymovement;

import com.silog.silog_user.domain.model.InventoryMovement;
import com.silog.silog_user.domain.port.in.InventoryMovement.CreateInventoryMovementUseCase;
import com.silog.silog_user.domain.port.in.InventoryMovement.GetInventoryMovementByIdUseCase;
import com.silog.silog_user.domain.port.in.InventoryMovement.GetInventoryMovementsUseCase;
import com.silog.silog_user.interfaces.rest.inventorymovement.dto.InventoryMovementRequest;
import com.silog.silog_user.interfaces.rest.inventorymovement.dto.InventoryMovementResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/inventory-movements")
public class InventoryMovementController {
    private final CreateInventoryMovementUseCase createInventoryMovementUseCase;
    private final GetInventoryMovementsUseCase getInventoryMovementsUseCase;
    private final GetInventoryMovementByIdUseCase getInventoryMovementByIdUseCase;

    public InventoryMovementController(
            CreateInventoryMovementUseCase createInventoryMovementUseCase,
            GetInventoryMovementsUseCase getInventoryMovementsUseCase,
            GetInventoryMovementByIdUseCase getInventoryMovementByIdUseCase
    ) {
        this.createInventoryMovementUseCase = createInventoryMovementUseCase;
        this.getInventoryMovementsUseCase = getInventoryMovementsUseCase;
        this.getInventoryMovementByIdUseCase = getInventoryMovementByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<InventoryMovementResponse>> getInventoryMovements() {
        List<InventoryMovement> inventoryMovements = getInventoryMovementsUseCase.getInventoryMovements();
        return ResponseEntity.ok(inventoryMovements.stream().map(InventoryMovementResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryMovementResponse> getInventoryMovementById(@PathVariable UUID id) {
        InventoryMovement inventoryMovement = getInventoryMovementByIdUseCase.getInventoryMovementById(id);
        return ResponseEntity.ok(InventoryMovementResponse.fromDomain(inventoryMovement));
    }

    @PostMapping
    public ResponseEntity<InventoryMovementResponse> createInventoryMovement(
            @RequestBody InventoryMovementRequest inventoryMovement
    ) {
        InventoryMovement created = createInventoryMovementUseCase.create(inventoryMovement.toDomain());
        return ResponseEntity.ok(InventoryMovementResponse.fromDomain(created));
    }
}
