package com.silog.silog_user.domain.port.in.Auth;

import com.silog.silog_user.domain.model.AuthToken;

public interface LoginUseCase {
    AuthToken login(String email, String password);
}
