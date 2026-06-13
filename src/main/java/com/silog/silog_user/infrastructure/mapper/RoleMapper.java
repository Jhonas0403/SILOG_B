package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Role;
import com.silog.silog_user.infrastructure.entity.RoleEntity;

public class RoleMapper {

    public static RoleEntity toEntity(Role role) {
        RoleEntity entity = new RoleEntity();
        entity.setId(role.getId());
        entity.setRoleName(role.getName());
        entity.setRoleDescription(role.getDescription());
        entity.setRoleStatus(role.getStatus());
        entity.setCreatedBy(role.getCreatedBy());
        entity.setUpdatedBy(role.getUpdatedBy());
        entity.setCreatedAt(role.getCreatedAt());
        entity.setUpdatedAt(role.getUpdatedAt());
        return entity;
    }

    public static Role toDomain(RoleEntity entity) {
        if (entity == null) return null;
        Role role = new Role();
        role.setId(entity.getId());
        role.setName(entity.getRoleName());
        role.setDescription(entity.getRoleDescription());
        role.setStatus(entity.getRoleStatus());
        role.setCreatedBy(entity.getCreatedBy());
        role.setUpdatedBy(entity.getUpdatedBy());
        role.setCreatedAt(entity.getCreatedAt());
        role.setUpdatedAt(entity.getUpdatedAt());
        return role;
    }
}
