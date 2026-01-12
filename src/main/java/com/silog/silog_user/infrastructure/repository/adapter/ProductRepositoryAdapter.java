package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Product;
import com.silog.silog_user.domain.port.out.ProductRepositoryPort;
import com.silog.silog_user.infrastructure.entity.ProductEntity;
import com.silog.silog_user.infrastructure.mapper.ProductMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepositoryAdapter  implements ProductRepositoryPort {

    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> products = jpaProductRepository.findAll();
        return products.stream().map(ProductMapper::toDomain).toList();
    }

    public Product findById(UUID id){
        ProductEntity product = jpaProductRepository.findById(id).orElse(null);
        return ProductMapper.toDomain(product);
    }
}
