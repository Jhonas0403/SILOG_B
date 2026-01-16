package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Brand;

import java.util.List;

public interface BrandRepositoryPort {
    List<Brand> findAll();
    Brand save(Brand brand);
}
