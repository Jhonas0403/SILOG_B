package com.silog.silog_user.application.service.Role;

import com.silog.silog_user.domain.model.Role;
import com.silog.silog_user.domain.port.in.Role.GetRoleByIdUseCase;
import com.silog.silog_user.domain.port.out.RoleRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetRoleByIdService implements GetRoleByIdUseCase {

    private final RoleRepositoryPort roleRepositoryPort;

    public GetRoleByIdService(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }

    @Override
    public Role getRoleById(UUID id) {
        return roleRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found: " + id));
    }
}
