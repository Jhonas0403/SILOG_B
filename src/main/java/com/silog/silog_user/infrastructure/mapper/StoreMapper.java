package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Store;
import com.silog.silog_user.infrastructure.entity.StoreEntity;

public class StoreMapper {

    public static StoreEntity toEntity(Store store) {
        StoreEntity entity = new StoreEntity();
        entity.setId(store.getId());
        entity.setCompanyId(store.getCompanyId());
        entity.setName(store.getName());
        entity.setAddress(store.getAddress());
        entity.setPhone(store.getPhone());
        entity.setStatus(store.getStatus());
        return entity;
    }

    public static Store toDomain(StoreEntity e) {
        if (e == null) return null;
        Store store = new Store();
        store.setId(e.getId());
        store.setCompanyId(e.getCompanyId());
        store.setName(e.getName());
        store.setAddress(e.getAddress());
        store.setPhone(e.getPhone());
        store.setStatus(e.getStatus());
        store.setCreatedAt(e.getCreatedAt());
        store.setUpdatedAt(e.getUpdatedAt());
        return store;
    }
}
