package com.silog.silog_user.domain.port.in.Products;

import com.silog.silog_user.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface GetProductUseCase {
    List<Product> getProducts(UUID storeId);
}
