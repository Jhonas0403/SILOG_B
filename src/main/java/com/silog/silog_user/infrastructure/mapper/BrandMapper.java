package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Brand;
import com.silog.silog_user.infrastructure.entity.BrandEntity;

public class BrandMapper {

    public static BrandEntity toEntity(Brand brand) {
        BrandEntity entity = new BrandEntity();
        entity.setId(brand.getId());
        entity.setBrandName(brand.getName());
        entity.setBrandDescription(brand.getDescription());
        entity.setBrandCategoryId(brand.getCategoryId());
        entity.setCategoryStatus(brand.getStatus());
        entity.setCreatedBy(brand.getCreatedBy());
        entity.setUpdatedBy(brand.getUpdatedBy());
        entity.setCreatedAt(brand.getCreatedAt());
        entity.setUpdatedAt(brand.getUpdatedAt());
        return entity;
    }

    public static Brand toDomain(BrandEntity entity) {
        Brand brand = new Brand();
        brand.setId(entity.getId());
        brand.setName(entity.getBrandName());
        brand.setDescription(entity.getBrandDescription());
        brand.setCategoryId(entity.getBrandCategoryId());
        brand.setStatus(entity.getCategoryStatus());
        brand.setCreatedBy(entity.getCreatedBy());
        brand.setUpdatedBy(entity.getUpdatedBy());
        brand.setCreatedAt(entity.getCreatedAt());
        brand.setUpdatedAt(entity.getUpdatedAt());
        return brand;
    }
}
