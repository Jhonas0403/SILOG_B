package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.out.UserRepositoryPort;
import com.silog.silog_user.infrastructure.entity.UserEntity;
import com.silog.silog_user.infrastructure.mapper.UserMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity saved = jpaUserRepository.save(entity);
        return UserMapper.toDomain(saved);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> users = jpaUserRepository.findAll();
        return  users.stream().map(UserMapper::toDomain).toList();
    }

    @Override
    public User findById(UUID id) {
        return jpaUserRepository.findById(id)
                .map(UserMapper::toDomain)
                .orElse(null);
    }

    @Override
    public User update(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        return UserMapper.toDomain(jpaUserRepository.save(entity));
    }

    @Override
    public User patch(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        return UserMapper.toDomain(jpaUserRepository.save(entity));
     }

}
