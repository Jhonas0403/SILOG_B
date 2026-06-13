package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Brand;
import com.silog.silog_user.infrastructure.entity.BrandEntity;

public class BrandMapper {

    public static BrandEntity toEntity(Brand brand) {
        BrandEntity entity = new BrandEntity();
        entity.setId(brand.getId());
        entity.setStoreId(brand.getStoreId());
        entity.setBrandName(brand.getName());
        entity.setBrandDescription(brand.getDescription());
        entity.setBrandSubcategoryId(brand.getSubcategoryId());
        entity.setBrandOrder(brand.getOrder());
        // BUG FIX: was entity.setCategoryStatus() — renamed to setBrandStatus()
        entity.setBrandStatus(brand.getStatus());
        return entity;
    }

    public static Brand toDomain(BrandEntity entity) {
        if (entity == null) {
            return null;
        }
        Brand brand = new Brand();
        brand.setId(entity.getId());
        brand.setStoreId(entity.getStoreId());
        brand.setName(entity.getBrandName());
        brand.setDescription(entity.getBrandDescription());
        brand.setSubcategoryId(entity.getBrandSubcategoryId());
        // BUG FIX: was entity.getCategoryStatus() — renamed to getBrandStatus()
        brand.setStatus(entity.getBrandStatus());
        brand.setOrder(entity.getBrandOrder());
        brand.setCreatedBy(entity.getCreatedBy());
        brand.setUpdatedBy(entity.getUpdatedBy());
        brand.setCreatedAt(entity.getCreatedAt());
        brand.setUpdatedAt(entity.getUpdatedAt());
        return brand;
    }
}
