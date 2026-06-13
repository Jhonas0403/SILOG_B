package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandRepositoryPort {
    List<Brand> findAll();
    List<Brand> findByStoreId(UUID storeId);
    Integer findMaxOrderByStoreId(UUID storeId);
    Brand save(Brand brand);
}
