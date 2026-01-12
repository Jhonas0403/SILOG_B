package com.silog.silog_user.infrastructure.mapper;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.infrastructure.entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity toProductEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setProductName(product.getName());
        entity.setProductBrandId(product.getBrandId());
        entity.setProductCategoryId(product.getCategoryId());
        entity.setProductBarcode(product.getBarcode());
        entity.setProductUnitMeasure(product.getMesure());
        entity.setProductPurchasePrice(product.getPurchasePrice());
        entity.setProductSalePrice(product.getSalePrice());
        entity.setProductMinSalePrice(product.getMinSalePrice());
        entity.setProductStock(product.getStock());
        entity.setProductDateEnd(product.getDateEnd());
        entity.setProductLot(product.getLot());
        entity.setProductRepositionDate(product.getRepositionDate());
        entity.setProductProfit(product.getProductProfit());
        entity.setProductStatus(product.getStatus());
        entity.setProductFromStoreId(product.getProductFromStoreId());
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
        product.setCategoryId(entity.getProductCategoryId());
        product.setBarcode(entity.getProductBarcode());
        product.setMesure(entity.getProductUnitMeasure());
        product.setPurchasePrice(entity.getProductPurchasePrice());
        product.setSalePrice(entity.getProductSalePrice());
        product.setMinSalePrice(entity.getProductMinSalePrice());
        product.setStock(entity.getProductStock());
        product.setStatus(entity.getProductStatus());
        product.setDateEnd(entity.getProductDateEnd());
        product.setLot(entity.getProductLot());
        product.setRepositionDate(entity.getProductRepositionDate());
        product.setProductProfit(entity.getProductProfit());
        product.setProductFromStoreId(entity.getProductFromStoreId());
        product.setCreatedAt(entity.getCreatedAt());
        product.setUpdatedAt(entity.getUpdatedAt());
        product.setUpdatedBy(entity.getUpdatedBy());
        product.setCreatedBy(entity.getCreatedBy());
        return product;
    }
}
