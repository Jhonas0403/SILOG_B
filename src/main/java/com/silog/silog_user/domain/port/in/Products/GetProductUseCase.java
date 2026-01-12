package com.silog.silog_user.domain.port.in.Products;

import com.silog.silog_user.domain.model.Product;

import java.util.List;

public interface GetProductUseCase {
    List<Product> getProducts();
}
