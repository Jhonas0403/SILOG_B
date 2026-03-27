package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, UUID> {
    List<CategoryEntity> findAllByOrderByCategoryOrderAsc();

    @Query("SELECT COALESCE(MAX(c.categoryOrder), 0) FROM CategoryEntity c")
    Integer findMaxCategoryOrder();
}
