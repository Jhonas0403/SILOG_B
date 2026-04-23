package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.SaleDetail;
import com.silog.silog_user.infrastructure.entity.SaleDetailEntity;

public class SaleDetailMapper {
    public static SaleDetailEntity toEntity(SaleDetail saleDetail) {
        SaleDetailEntity entity = new SaleDetailEntity();
        entity.setId(saleDetail.getId());
        entity.setSaleId(saleDetail.getSaleId());
        entity.setVariantId(saleDetail.getVariantId());
        entity.setQuantity(saleDetail.getQuantity());
        entity.setSalePrice(saleDetail.getSalePrice());
        entity.setPurchasePrice(saleDetail.getPurchasePrice());
        entity.setSubtotal(saleDetail.getSubtotal());
        entity.setStatus(saleDetail.getStatus());
        entity.setCreatedBy(saleDetail.getCreatedBy());
        entity.setUpdatedBy(saleDetail.getUpdatedBy());
        entity.setCreatedAt(saleDetail.getCreatedAt());
        entity.setUpdatedAt(saleDetail.getUpdatedAt());
        return entity;
    }

    public static SaleDetail toDomain(SaleDetailEntity entity) {
        if (entity == null) {
            return null;
        }
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setId(entity.getId());
        saleDetail.setSaleId(entity.getSaleId());
        saleDetail.setVariantId(entity.getVariantId());
        saleDetail.setQuantity(entity.getQuantity());
        saleDetail.setSalePrice(entity.getSalePrice());
        saleDetail.setPurchasePrice(entity.getPurchasePrice());
        saleDetail.setSubtotal(entity.getSubtotal());
        saleDetail.setStatus(entity.getStatus());
        saleDetail.setCreatedBy(entity.getCreatedBy());
        saleDetail.setUpdatedBy(entity.getUpdatedBy());
        saleDetail.setCreatedAt(entity.getCreatedAt());
        saleDetail.setUpdatedAt(entity.getUpdatedAt());
        return saleDetail;
    }
}
