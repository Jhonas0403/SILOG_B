package com.silog.silog_user.application.service.Role;

import com.silog.silog_user.domain.model.Role;
import com.silog.silog_user.domain.port.in.Role.GetRolesUseCase;
import com.silog.silog_user.domain.port.out.RoleRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRolesService implements GetRolesUseCase {

    private final RoleRepositoryPort roleRepositoryPort;

    public GetRolesService(RoleRepositoryPort roleRepositoryPort) {
        this.roleRepositoryPort = roleRepositoryPort;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepositoryPort.findAll();
    }
}
