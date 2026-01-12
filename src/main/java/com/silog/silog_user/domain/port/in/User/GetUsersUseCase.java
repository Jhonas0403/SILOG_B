package com.silog.silog_user.domain.port.in.User;

import com.silog.silog_user.domain.model.User;

import java.util.List;

public interface GetUsersUseCase {
    List<User> getUsers();
}
