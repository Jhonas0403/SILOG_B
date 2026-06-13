package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.infrastructure.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User user){
        UserEntity entity = new UserEntity();
        // BUG FIX: was entity.setUserId() — with Lombok the correct method is setId()
        entity.setId(user.getId());
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
        entity.setUserRoleId(user.getUserRoleId());
        // Note: createdAt, updatedAt handled automatically by AuditingEntityListener
        return entity;
    }

    public static User toDomain(UserEntity e){
        if (e == null) {
            return null;
        }
        User user = new User();
        // BUG FIX: was e.getUserId() — with Lombok the correct method is getId()
        user.setId(e.getId());
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
