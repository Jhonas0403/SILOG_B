package com.silog.silog_user.domain.port.in.User;

import com.silog.silog_user.domain.model.User;

public interface GetUserByIdUseCase {
    User findById(long id);
}
