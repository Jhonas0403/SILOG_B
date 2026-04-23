package com.silog.silog_user.application.service.User;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.model.UserPatch;
import com.silog.silog_user.domain.port.in.User.PatchUserUseCase;
import com.silog.silog_user.domain.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PatchUserService implements PatchUserUseCase {

    private final UserRepositoryPort repository;

    public PatchUserService(UserRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public User patch (UUID id, UserPatch user) {
        User userFinder = repository.findById(id);
        if (userFinder == null) {
            throw new RuntimeException("User not found");
        }
        if (user.getAddress() != null) {
            userFinder.setAddress(user.getAddress());
        }
        if (user.getPhone() != null) {
            userFinder.setPhone(user.getPhone());
        }
        if (user.getPassword() != null) {
            userFinder.setPassword(user.getPassword());
        }
        if (user.getStatus() != null) {
            userFinder.setStatus(user.getStatus());
        }
        userFinder.setUpdatedAt(LocalDateTime.now());
        return repository.patch(userFinder);
    }
}
