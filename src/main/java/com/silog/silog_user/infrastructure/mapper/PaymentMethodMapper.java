package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.PaymentMethod;
import com.silog.silog_user.infrastructure.entity.PaymentMethodEntity;

public class PaymentMethodMapper {

    public static PaymentMethodEntity toEntity(PaymentMethod pm) {
        PaymentMethodEntity entity = new PaymentMethodEntity();
        entity.setId(pm.getId());
        entity.setName(pm.getName());
        entity.setDescription(pm.getDescription());
        entity.setRequiresOperationCode(pm.getRequiresOperationCode());
        entity.setStatus(pm.getStatus());
        return entity;
    }

    public static PaymentMethod toDomain(PaymentMethodEntity e) {
        if (e == null) return null;
        PaymentMethod pm = new PaymentMethod();
        pm.setId(e.getId());
        pm.setName(e.getName());
        pm.setDescription(e.getDescription());
        pm.setRequiresOperationCode(e.getRequiresOperationCode());
        pm.setStatus(e.getStatus());
        pm.setCreatedAt(e.getCreatedAt());
        pm.setUpdatedAt(e.getUpdatedAt());
        return pm;
    }
}
