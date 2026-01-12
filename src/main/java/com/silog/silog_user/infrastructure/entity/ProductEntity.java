package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false, updatable = false)
    private UUID id;

    @Column (name = "product_name")
    private String productName;

    @Column (name = "product_brand_id")
    private UUID productBrandId;

    @Column (name = "product_category_id")
    private UUID productCategoryId;

    @Column (name = "product_barcode")
    private String productBarcode;

    @Column (name = "product_unit_measure")
    private String productUnitMeasure;

    @Column (name = "product_purchase_price")
    private Double productPurchasePrice;

    @Column (name = "product_sale_price")
    private Double productSalePrice;

    @Column (name = "product_min_sale_price")
    private Double productMinSalePrice;

    @Column (name = "product_stock")
    private Integer productStock;

    @Column (name = "product_status")
    private Boolean productStatus;

    @Column (name = "product_date_end")
    private LocalDateTime productDateEnd;

    @Column (name = "product_lot")
    private String productLot;

    @Column (name = "product_reposition_date")
    private LocalDateTime productRepositionDate;

    @Column (name = "product_profit")
    private Double productProfit;

    @Column (name = "product_from_store_id")
    private UUID productFromStoreId;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public ProductEntity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public UUID getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(UUID productBrandId) {
        this.productBrandId = productBrandId;
    }

    public UUID getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(UUID productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public String getProductUnitMeasure() {
        return productUnitMeasure;
    }

    public void setProductUnitMeasure(String productUnitMeasure) {
        this.productUnitMeasure = productUnitMeasure;
    }

    public Double getProductPurchasePrice() {
        return productPurchasePrice;
    }

    public void setProductPurchasePrice(Double productPurchasePrice) {
        this.productPurchasePrice = productPurchasePrice;
    }

    public Double getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(Double productSalePrice) {
        this.productSalePrice = productSalePrice;
    }

    public Double getProductMinSalePrice() {
        return productMinSalePrice;
    }

    public void setProductMinSalePrice(Double productMinSalePrice) {
        this.productMinSalePrice = productMinSalePrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    public LocalDateTime getProductDateEnd() {
        return productDateEnd;
    }

    public void setProductDateEnd(LocalDateTime productDateEnd) {
        this.productDateEnd = productDateEnd;
    }

    public String getProductLot() {
        return productLot;
    }

    public void setProductLot(String productLot) {
        this.productLot = productLot;
    }

    public LocalDateTime getProductRepositionDate() {
        return productRepositionDate;
    }

    public void setProductRepositionDate(LocalDateTime productRepositionDate) {
        this.productRepositionDate = productRepositionDate;
    }

    public Double getProductProfit() {
        return productProfit;
    }

    public void setProductProfit(Double productProfit) {
        this.productProfit = productProfit;
    }

    public UUID getProductFromStoreId() {
        return productFromStoreId;
    }

    public void setProductFromStoreId(UUID productFromStoreId) {
        this.productFromStoreId = productFromStoreId;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
