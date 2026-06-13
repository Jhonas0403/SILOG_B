package com.silog.silog_user.interfaces.rest.store;

import com.silog.silog_user.domain.model.Store;
import com.silog.silog_user.domain.port.in.Store.CreateStoreUseCase;
import com.silog.silog_user.domain.port.in.Store.GetStoreByIdUseCase;
import com.silog.silog_user.domain.port.in.Store.GetStoresByCompanyUseCase;
import com.silog.silog_user.domain.port.in.Store.GetStoresUseCase;
import com.silog.silog_user.infrastructure.security.UserPrincipal;
import com.silog.silog_user.interfaces.rest.store.dto.StoreRequest;
import com.silog.silog_user.interfaces.rest.store.dto.StoreResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final CreateStoreUseCase createStoreUseCase;
    private final GetStoresUseCase getStoresUseCase;
    private final GetStoresByCompanyUseCase getStoresByCompanyUseCase;
    private final GetStoreByIdUseCase getStoreByIdUseCase;

    public StoreController(CreateStoreUseCase createStoreUseCase,
                           GetStoresUseCase getStoresUseCase,
                           GetStoresByCompanyUseCase getStoresByCompanyUseCase,
                           GetStoreByIdUseCase getStoreByIdUseCase) {
        this.createStoreUseCase = createStoreUseCase;
        this.getStoresUseCase = getStoresUseCase;
        this.getStoresByCompanyUseCase = getStoresByCompanyUseCase;
        this.getStoreByIdUseCase = getStoreByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<StoreResponse>> getStores() {
        UserPrincipal principal = getPrincipal();
        List<Store> stores;

        if ("ADMIN".equals(principal.getRoleName()) && principal.getCompanyId() != null) {
            stores = getStoresByCompanyUseCase.getByCompany(UUID.fromString(principal.getCompanyId()));
        } else {
            stores = getStoresUseCase.getAll();
        }

        return ResponseEntity.ok(stores.stream().map(StoreResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(StoreResponse.fromDomain(getStoreByIdUseCase.getById(id)));
    }

    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    @PostMapping
    public ResponseEntity<StoreResponse> create(@Valid @RequestBody StoreRequest request) {
        UserPrincipal principal = getPrincipal();
        Store store = request.toDomain();

        if ("ADMIN".equals(principal.getRoleName())) {
            if (principal.getCompanyId() == null) {
                throw new IllegalArgumentException("El administrador no tiene una empresa asignada");
            }
            store.setCompanyId(UUID.fromString(principal.getCompanyId()));
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(StoreResponse.fromDomain(createStoreUseCase.create(store)));
    }

    private UserPrincipal getPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (UserPrincipal) auth.getPrincipal();
    }
}
