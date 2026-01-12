package com.silog.silog_user.application.service.User;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.in.User.CreateUserUseCase;
import com.silog.silog_user.domain.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    @Override
    public User create(User user) {
        User savedUser = userRepositoryPort.save(user);
        return savedUser;

    }
}
