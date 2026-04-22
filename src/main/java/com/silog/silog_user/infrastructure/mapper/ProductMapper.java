package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.infrastructure.entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity toProductEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setProductName(product.getName());
        entity.setProductBrandId(product.getBrandId());
        entity.setProductOrder(product.getOrder());
        entity.setProductStatus(product.getStatus());
        entity.setCreatedBy(product.getCreatedBy());
        entity.setUpdatedBy(product.getUpdatedBy());
        entity.setCreatedAt(product.getCreatedAt());
        entity.setUpdatedAt(product.getUpdatedAt());
        return entity;
    }

    public static Product toDomain(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getProductName());
        product.setBrandId(entity.getProductBrandId());
        product.setStatus(entity.getProductStatus());
        product.setOrder(entity.getProductOrder());
        product.setCreatedAt(entity.getCreatedAt());
        product.setUpdatedAt(entity.getUpdatedAt());
        product.setUpdatedBy(entity.getUpdatedBy());
        product.setCreatedBy(entity.getCreatedBy());
        return product;
    }
}
