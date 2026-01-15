package com.silog.silog_user.application.service.Products;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.domain.port.in.Products.CreateProductUseCase;


import com.silog.silog_user.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

@Service

public class CreateProductService  implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product create(Product product) {
        return productRepositoryPort.save(product);
    }
}
