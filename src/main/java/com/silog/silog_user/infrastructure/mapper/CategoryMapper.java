package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.infrastructure.entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryEntity toEntity(Category category) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setCategoryName(category.getName());
        entity.setCategoryDescription(category.getDescription());
        entity.setCategoryStatus(category.getStatus());
        entity.setCreatedBy(category.getCreatedBy());
        entity.setUpdatedBy(category.getUpdatedBy());
        entity.setCreatedAt(category.getCreatedAt());
        entity.setUpdatedAt(category.getUpdatedAt());
        return entity;
    }

    public static Category toDomain(CategoryEntity entity) {
        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getCategoryName());
        category.setDescription(entity.getCategoryDescription());
        category.setStatus(entity.getCategoryStatus());
        category.setCreatedBy(entity.getCreatedBy());
        category.setUpdatedBy(entity.getUpdatedBy());
        category.setCreatedAt(entity.getCreatedAt());
        category.setUpdatedAt(entity.getUpdatedAt());
        return category;
    }
}
