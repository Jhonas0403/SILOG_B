package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.infrastructure.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User user){
        UserEntity entity = new UserEntity();
        entity.setUserId(user.getId());
        entity.setCompanyId(user.getCompanyId());
        entity.setStoreId(user.getStoreId());
        entity.setUserName(user.getFirstName());
        entity.setUserLastname(user.getLastName());
        entity.setUserDni(user.getDni());
        entity.setUserEmail(user.getEmail());
        entity.setUserPassword(user.getPassword());
        entity.setUserPhone(user.getPhone());
        entity.setUserAddress(user.getAddress());
        entity.setUserStatus(user.getStatus());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        entity.setUserRoleId(user.getUserRoleId());
        return entity;
    }

    public static User toDomain(UserEntity e){
        User user = new User();
        user.setId(e.getUserId());
        user.setCompanyId(e.getCompanyId());
        user.setStoreId(e.getStoreId());
        user.setFirstName(e.getUserName());
        user.setLastName(e.getUserLastname());
        user.setDni(e.getUserDni());
        user.setEmail(e.getUserEmail());
        user.setPassword(e.getUserPassword());
        user.setPhone(e.getUserPhone());
        user.setAddress(e.getUserAddress());
        user.setUserRoleId(e.getUserRoleId());
        user.setStatus(e.getUserStatus());
        user.setCreatedAt(e.getCreatedAt());
        user.setUpdatedAt(e.getUpdatedAt());
        return user;
    }
}
