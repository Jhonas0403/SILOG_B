package com.silog.silog_user.interfaces.rest.inventorymovement;

import com.silog.silog_user.domain.model.InventoryMovement;
import com.silog.silog_user.domain.port.in.InventoryMovement.CreateInventoryMovementUseCase;
import com.silog.silog_user.domain.port.in.InventoryMovement.GetInventoryMovementByIdUseCase;
import com.silog.silog_user.domain.port.in.InventoryMovement.GetInventoryMovementsUseCase;
import com.silog.silog_user.interfaces.rest.inventorymovement.dto.InventoryMovementRequest;
import com.silog.silog_user.interfaces.rest.inventorymovement.dto.InventoryMovementResponse;
import org.springframework.http.ResponseEntity;
import com.silog.silog_user.infrastructure.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        UUID storeId = getStoreIdFromJwt();
        List<InventoryMovement> inventoryMovements = getInventoryMovementsUseCase.getInventoryMovements(storeId);
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
        InventoryMovement dom = inventoryMovement.toDomain();
        dom.setStoreId(getStoreIdFromJwt());
        InventoryMovement created = createInventoryMovementUseCase.create(dom);
        return ResponseEntity.ok(InventoryMovementResponse.fromDomain(created));
    }

    private UUID getStoreIdFromJwt() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        return principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
    }
}
