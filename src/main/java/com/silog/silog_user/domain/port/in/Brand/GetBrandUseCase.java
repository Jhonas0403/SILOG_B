package com.silog.silog_user.domain.port.in.Brand;

import com.silog.silog_user.domain.model.Brand;

import java.util.List;
import java.util.UUID;

public interface GetBrandUseCase {
    List<Brand> getBrands(UUID storeId);
}
