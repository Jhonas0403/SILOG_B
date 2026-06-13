package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Subcategory;

import java.util.List;
import java.util.UUID;

public interface SubcategoryRepositoryPort {
    List<Subcategory> findAll();
    List<Subcategory> findByStoreId(UUID storeId);
    Integer findMaxOrderByStoreId(UUID storeId);
    Subcategory save(Subcategory subcategory);
}
