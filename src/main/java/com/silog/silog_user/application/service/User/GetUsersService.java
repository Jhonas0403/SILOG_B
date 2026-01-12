package com.silog.silog_user.application.service.User;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.in.User.GetUsersUseCase;
import com.silog.silog_user.domain.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersService implements GetUsersUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public GetUsersService (UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public List<User> getUsers() {

    return userRepositoryPort.findAll();
    }
}
