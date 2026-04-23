package com.silog.silog_user.application.service.User;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.in.User.PutUserUseCase;
import com.silog.silog_user.domain.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PutUserService implements PutUserUseCase {
    private UserRepositoryPort userRepositoryPort;
    public PutUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }
    @Override
    public User update(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        return userRepositoryPort.update(user);
    }
}
