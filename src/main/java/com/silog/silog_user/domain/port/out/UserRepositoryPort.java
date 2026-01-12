package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.interfaces.rest.user.dto.UpdateRequestUser;

import java.util.List;

public interface UserRepositoryPort {
    User save(User user);
    List<User> findAll();
    User findById(long id);
    User update(User user);
    User patch( User user);
}
