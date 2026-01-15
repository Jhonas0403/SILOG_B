package com.silog.silog_user.domain.port.in.Products;

import com.silog.silog_user.domain.model.Product;

public interface CreateProductUseCase {
    Product create(Product product);
}
