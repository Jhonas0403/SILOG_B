package com.silog.silog_user.application.service.Products;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.domain.port.in.Products.GetProductByIdUseCase;
import com.silog.silog_user.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class GetProductByIdService implements GetProductByIdUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public GetProductByIdService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product getProductById(UUID id) {
        Product product = productRepositoryPort.findById(id);
        return product;
    }
}
