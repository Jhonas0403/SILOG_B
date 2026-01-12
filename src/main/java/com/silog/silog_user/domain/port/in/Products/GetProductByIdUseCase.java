package com.silog.silog_user.domain.port.in.Products;

import com.silog.silog_user.domain.model.Product;

import java.util.UUID;

public interface GetProductByIdUseCase {
    Product getProductById(UUID id);

}
