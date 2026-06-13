package com.silog.silog_user.domain.port.in.Role;

import com.silog.silog_user.domain.model.Role;

import java.util.UUID;

public interface GetRoleByIdUseCase {
    Role getRoleById(UUID id);
}
