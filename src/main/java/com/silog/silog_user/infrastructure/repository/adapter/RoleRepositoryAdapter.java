package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Role;
import com.silog.silog_user.domain.port.out.RoleRepositoryPort;
import com.silog.silog_user.infrastructure.mapper.RoleMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RoleRepositoryAdapter implements RoleRepositoryPort {

    private final JpaRoleRepository jpaRoleRepository;

    public RoleRepositoryAdapter(JpaRoleRepository jpaRoleRepository) {
        this.jpaRoleRepository = jpaRoleRepository;
    }

    @Override
    public List<Role> findAll() {
        return jpaRoleRepository.findAll().stream().map(RoleMapper::toDomain).toList();
    }

    @Override
    public Optional<Role> findById(UUID id) {
        return jpaRoleRepository.findById(id).map(RoleMapper::toDomain);
    }

    @Override
    public Role save(Role role) {
        return RoleMapper.toDomain(jpaRoleRepository.save(RoleMapper.toEntity(role)));
    }
}
