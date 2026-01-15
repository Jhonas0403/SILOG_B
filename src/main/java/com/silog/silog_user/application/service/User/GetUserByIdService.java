package com.silog.silog_user.application.service.User;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.in.User.GetUserByIdUseCase;
import com.silog.silog_user.domain.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetUserByIdService implements GetUserByIdUseCase {

    private UserRepositoryPort userRepositoryPort;

    public GetUserByIdService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User findById(UUID id){
        User user = userRepositoryPort.findById(id);
        return user;
    }

}
