package com.silog.silog_user.application.service.Products;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.domain.port.in.Products.GetProductUseCase;
import com.silog.silog_user.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetProductService implements GetProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public GetProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<Product> getProducts(UUID storeId) {
        if (storeId != null) return productRepositoryPort.findByStoreId(storeId);
        return productRepositoryPort.findAll();
    }
}
