package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Subcategory;
import com.silog.silog_user.infrastructure.entity.SubcategoryEntity;

public class SubcategoryMapper {

    public static SubcategoryEntity toEntity(Subcategory subcategory) {
        SubcategoryEntity entity = new SubcategoryEntity();
        entity.setSubcategoryId(subcategory.getId());
        entity.setSubcategoryName(subcategory.getName());
        entity.setSubcategoryStatus(subcategory.getStatus());
        entity.setSubcategoryOrder(subcategory.getOrder());
        entity.setCategoryId(subcategory.getCategoryId());
        entity.setCreatedBy(subcategory.getCreatedBy());
        entity.setUpdatedBy(subcategory.getUpdatedBy());
        entity.setCreatedAt(subcategory.getCreatedAt());
        entity.setUpdatedAt(subcategory.getUpdatedAt());
        return  entity;
    }

    public static Subcategory toDomain(SubcategoryEntity entity) {
        Subcategory subcategory = new Subcategory();
        subcategory.setId(entity.getSubcategoryId());
        subcategory.setName(entity.getSubcategoryName());
        subcategory.setStatus(entity.getSubcategoryStatus());
        subcategory.setOrder(entity.getSubcategoryOrder());
        subcategory.setCategoryId(entity.getCategoryId());
        subcategory.setCreatedBy(entity.getCreatedBy());
        subcategory.setUpdatedBy(entity.getUpdatedBy());
        subcategory.setCreatedAt(entity.getCreatedAt());
        subcategory.setUpdatedAt(entity.getUpdatedAt());
        return subcategory;
    }
}
