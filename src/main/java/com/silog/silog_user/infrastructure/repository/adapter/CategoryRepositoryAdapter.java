package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.domain.port.out.CategoryRepositoryPort;
import com.silog.silog_user.infrastructure.entity.CategoryEntity;
import com.silog.silog_user.infrastructure.mapper.CategoryMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaCategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryRepositoryAdapter(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categories = jpaCategoryRepository.findAllByOrderByCategoryOrderAsc();
        return categories.stream().map(CategoryMapper::toDomain).toList();
    }

    @Override
    public List<Category> findByStoreId(UUID storeId) {
        return jpaCategoryRepository.findByStoreIdOrderByCategoryOrderAsc(storeId)
                .stream().map(CategoryMapper::toDomain).toList();
    }

    @Override
    public Integer findMaxOrderByStoreId(UUID storeId) {
        return jpaCategoryRepository.findMaxCategoryOrderByStoreId(storeId);
    }

    @Override
    public Category save(Category category) {
        CategoryEntity entity = CategoryMapper.toEntity(category);
        entity = jpaCategoryRepository.save(entity);
        return CategoryMapper.toDomain(entity);
    }
}
