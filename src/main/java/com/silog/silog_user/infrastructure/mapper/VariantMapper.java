package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.infrastructure.entity.VariantEntity;

public class VariantMapper {

    public static VariantEntity toEntity(Variant variant) {
        VariantEntity entity = new VariantEntity();
        entity.setVariantId(variant.getId());
        entity.setStoreId(variant.getStoreId());
        entity.setVariantProductId(variant.getProductId());
        entity.setVariantName(variant.getName());
        entity.setVariantBarcode(variant.getBarcode());
        entity.setVariantOrder(variant.getOrder());
        entity.setVariantStock(variant.getStock());
        entity.setVariantPurchasePrice(variant.getPurchasePrice());
        entity.setVariantSalePrice(variant.getSalePrice());
        entity.setVariantMinSalePrice(variant.getMinSalePrice());
        entity.setVariantStatus(variant.getStatus());
        // Note: audit fields handled automatically by AuditingEntityListener
        return entity;
    }

    public static Variant toDomain(VariantEntity entity) {
        if (entity == null) {
            return null;
        }
        Variant variant = new Variant();
        variant.setId(entity.getVariantId());
        variant.setStoreId(entity.getStoreId());
        variant.setProductId(entity.getVariantProductId());
        variant.setName(entity.getVariantName());
        variant.setBarcode(entity.getVariantBarcode());
        variant.setOrder(entity.getVariantOrder());
        variant.setStock(entity.getVariantStock());
        variant.setPurchasePrice(entity.getVariantPurchasePrice());
        variant.setSalePrice(entity.getVariantSalePrice());
        variant.setMinSalePrice(entity.getVariantMinSalePrice());
        variant.setStatus(entity.getVariantStatus());
        return variant;
    }
}
