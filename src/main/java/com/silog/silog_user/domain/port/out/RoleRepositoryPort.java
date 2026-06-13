package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepositoryPort {
    List<Role> findAll();
    Optional<Role> findById(UUID id);
    Role save(Role role);
}
