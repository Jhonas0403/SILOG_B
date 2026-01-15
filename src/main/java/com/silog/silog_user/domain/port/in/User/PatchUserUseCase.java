package com.silog.silog_user.domain.port.in.User;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.interfaces.rest.user.dto.UpdateRequestUser;

import java.util.UUID;

public interface PatchUserUseCase {
    User patch(UUID id, UpdateRequestUser user);
}
