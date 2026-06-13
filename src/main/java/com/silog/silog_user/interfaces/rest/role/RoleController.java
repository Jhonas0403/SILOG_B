package com.silog.silog_user.interfaces.rest.role;

import com.silog.silog_user.domain.model.Role;
import com.silog.silog_user.domain.port.in.Role.CreateRoleUseCase;
import com.silog.silog_user.domain.port.in.Role.GetRoleByIdUseCase;
import com.silog.silog_user.domain.port.in.Role.GetRolesUseCase;
import com.silog.silog_user.interfaces.rest.role.dto.RoleRequest;
import com.silog.silog_user.interfaces.rest.role.dto.RoleResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final CreateRoleUseCase createRoleUseCase;
    private final GetRolesUseCase getRolesUseCase;
    private final GetRoleByIdUseCase getRoleByIdUseCase;

    public RoleController(CreateRoleUseCase createRoleUseCase,
                          GetRolesUseCase getRolesUseCase,
                          GetRoleByIdUseCase getRoleByIdUseCase) {
        this.createRoleUseCase = createRoleUseCase;
        this.getRolesUseCase = getRolesUseCase;
        this.getRoleByIdUseCase = getRoleByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getRoles() {
        List<Role> roles = getRolesUseCase.getRoles();
        return ResponseEntity.ok(roles.stream().map(RoleResponse::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable UUID id) {
        Role role = getRoleByIdUseCase.getRoleById(id);
        return ResponseEntity.ok(RoleResponse.fromDomain(role));
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping
    public ResponseEntity<RoleResponse> createRole(@Valid @RequestBody RoleRequest request) {
        Role created = createRoleUseCase.create(request.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(RoleResponse.fromDomain(created));
    }
}
