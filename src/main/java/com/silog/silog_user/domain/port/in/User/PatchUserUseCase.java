package com.silog.silog_user.domain.port.in.User;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.interfaces.rest.user.dto.UpdateRequestUser;

public interface PatchUserUseCase {
    User patch(Long id, UpdateRequestUser user);
}
