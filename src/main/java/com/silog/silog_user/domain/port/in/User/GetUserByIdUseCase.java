package com.silog.silog_user.domain.port.in.User;

import com.silog.silog_user.domain.model.User;

import java.util.UUID;

public interface GetUserByIdUseCase {
    User findById(UUID id);
}
