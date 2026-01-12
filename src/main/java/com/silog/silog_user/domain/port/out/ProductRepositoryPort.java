package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepositoryPort {
    List<Product> findAll();
    Product findById(UUID id);
}
