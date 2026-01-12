package com.silog.silog_user.application.service.User;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.in.User.PatchUserUseCase;
import com.silog.silog_user.domain.port.out.UserRepositoryPort;
import com.silog.silog_user.interfaces.rest.user.dto.UpdateRequestUser;
import org.springframework.stereotype.Service;

@Service
public class PatchUserService implements PatchUserUseCase {

    private final UserRepositoryPort repository;

    public PatchUserService(UserRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public User patch (Long id,UpdateRequestUser user) {
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
        if (user.getStatus() != null) {
            userFinder.setStatus(user.getStatus());
        }
        return repository.patch(userFinder);
    }
}
