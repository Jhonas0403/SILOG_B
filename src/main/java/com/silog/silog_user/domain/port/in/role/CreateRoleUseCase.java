package com.silog.silog_user.domain.port.in.Role;

import com.silog.silog_user.domain.model.Role;

public interface CreateRoleUseCase {
    Role create(Role role);
}
