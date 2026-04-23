package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Sale;
import com.silog.silog_user.infrastructure.entity.SaleEntity;

public class SaleMapper {
    public static SaleEntity toEntity(Sale sale) {
        SaleEntity entity = new SaleEntity();
        entity.setId(sale.getId());
        entity.setSaleDate(sale.getSaleDate());
        entity.setTotal(sale.getTotal());
        entity.setStatus(sale.getStatus());
        entity.setCreatedBy(sale.getCreatedBy());
        entity.setUpdatedBy(sale.getUpdatedBy());
        entity.setCreatedAt(sale.getCreatedAt());
        entity.setUpdatedAt(sale.getUpdatedAt());
        return entity;
    }

    public static Sale toDomain(SaleEntity entity) {
        if (entity == null) {
            return null;
        }
        Sale sale = new Sale();
        sale.setId(entity.getId());
        sale.setSaleDate(entity.getSaleDate());
        sale.setTotal(entity.getTotal());
        sale.setStatus(entity.getStatus());
        sale.setCreatedBy(entity.getCreatedBy());
        sale.setUpdatedBy(entity.getUpdatedBy());
        sale.setCreatedAt(entity.getCreatedAt());
        sale.setUpdatedAt(entity.getUpdatedAt());
        return sale;
    }
}
