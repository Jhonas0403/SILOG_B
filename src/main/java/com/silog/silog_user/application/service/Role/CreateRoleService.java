package com.silog.silog_user.application.service.Role;

import com.silog.silog_user.domain.model.Role;
import com.silog.silog_user.domain.port.in.Role.CreateRoleUseCase;
import com.silog.silog_user.domain.port.out.RoleRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateRoleService implements CreateRoleUseCase {

    private final RoleRepositoryPort roleRepositoryPort;

    public CreateRoleService(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }

    @Override
    public Role create(Role role) {
        if (role.getStatus() == null) {
            role.setStatus(true);
        }
        return roleRepositoryPort.save(role);
    }
}
