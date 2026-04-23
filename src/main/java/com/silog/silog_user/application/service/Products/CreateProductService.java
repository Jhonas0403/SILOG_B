package com.silog.silog_user.application.service.Products;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.domain.port.in.Products.CreateProductUseCase;


import com.silog.silog_user.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class CreateProductService  implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product create(Product product) {
        Integer nextOrder = productRepositoryPort.findMaxOrder() + 1;
        product.setOrder(nextOrder);

        if(product.getStatus() == null) product.setStatus(true);
        if(product.getUpdatedBy() == null) product.setUpdatedBy(product.getCreatedBy());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepositoryPort.save(product);
    }
}
