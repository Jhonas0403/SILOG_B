package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface JpaUserRepository  extends JpaRepository<UserEntity, Long> {
}