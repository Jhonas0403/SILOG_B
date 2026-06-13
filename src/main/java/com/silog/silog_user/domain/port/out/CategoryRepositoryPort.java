package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryRepositoryPort {
    List<Category> findAll();
    List<Category> findByStoreId(UUID storeId);
    Integer findMaxOrderByStoreId(UUID storeId);
    Category save(Category category);
}
