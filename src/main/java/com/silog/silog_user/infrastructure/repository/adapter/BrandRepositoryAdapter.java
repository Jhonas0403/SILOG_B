package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Brand;
import com.silog.silog_user.domain.port.out.BrandRepositoryPort;
import com.silog.silog_user.infrastructure.entity.BrandEntity;
import com.silog.silog_user.infrastructure.mapper.BrandMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaBrandRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class BrandRepositoryAdapter implements BrandRepositoryPort {
    private final JpaBrandRepository jpaBrandRepository;
    public BrandRepositoryAdapter(JpaBrandRepository jpaBrandRepository) {
        this.jpaBrandRepository = jpaBrandRepository;
    }

    @Override
    public List<Brand> findAll() {
        List<BrandEntity> brands = jpaBrandRepository.findAll();
        return brands.stream().map(BrandMapper::toDomain).toList();
    }

    @Override
    public Brand save(Brand brand) {
        BrandEntity brandEntity = BrandMapper.toEntity(brand);
        brandEntity = jpaBrandRepository.save(brandEntity);
        return BrandMapper.toDomain(brandEntity);
    }

    @Override
    public List<Brand> findByStoreId(UUID storeId) {
        return jpaBrandRepository.findByStoreIdOrderByBrandOrderAsc(storeId)
                .stream().map(BrandMapper::toDomain).toList();
    }

    @Override
    public Integer findMaxOrderByStoreId(UUID storeId) {
        return jpaBrandRepository.findMaxBrandOrderByStoreId(storeId);
    }
}
