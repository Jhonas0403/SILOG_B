package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.infrastructure.entity.VariantEntity;

public class VariantMapper {

    public static VariantEntity toEntity(Variant variant) {
        VariantEntity entity = new VariantEntity();
        entity.setVariantId(variant.getId());
        entity.setVariantProductId(variant.getProductId());
        entity.setVariantName(variant.getName());
        entity.setVariantBarcode(variant.getBarcode());
        entity.setVariantOrder(variant.getOrder());
        entity.setVariantStock(variant.getStock());
        entity.setVariantPurchasePrice(variant.getPurchasePrice());
        entity.setVariantSalePrice(variant.getSalePrice());
        entity.setVariantMinSalePrice(variant.getMinSalePrice());
        entity.setVariantStatus(variant.getStatus());
        entity.setCreatedAt(variant.getCreatedAt());
        entity.setUpdatedAt(variant.getUpdatedAt());
        entity.setCreatedBy(variant.getCreatedBy());
        entity.setUpdatedBy(variant.getUpdatedBy());
        return entity;
    }

    public static Variant toDomain(VariantEntity entity) {
        Variant variant = new Variant();
        variant.setId(entity.getVariantId());
        variant.setProductId(entity.getVariantProductId());
        variant.setName(entity.getVariantName());
        variant.setBarcode(entity.getVariantBarcode());
        variant.setOrder(entity.getVariantOrder());
        variant.setStock(entity.getVariantStock());
        variant.setPurchasePrice(entity.getVariantPurchasePrice());
        variant.setSalePrice(entity.getVariantSalePrice());
        variant.setMinSalePrice(entity.getVariantMinSalePrice());
        variant.setStatus(entity.getVariantStatus());
        variant.setCreatedAt(entity.getCreatedAt());
        variant.setUpdatedAt(entity.getUpdatedAt());
        variant.setCreatedBy(entity.getCreatedBy());
        variant.setUpdatedBy(entity.getUpdatedBy());
        return variant;

    }

}
