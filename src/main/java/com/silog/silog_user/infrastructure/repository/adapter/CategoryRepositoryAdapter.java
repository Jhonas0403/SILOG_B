package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.domain.port.out.CategoryRepositoryPort;
import com.silog.silog_user.infrastructure.entity.CategoryEntity;
import com.silog.silog_user.infrastructure.mapper.CategoryMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaCategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryRepositoryAdapter(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categories = jpaCategoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toDomain).toList();
    }

    @Override
    public Category save(Category category) {
        CategoryEntity entity = CategoryMapper.toEntity(category);
        entity = jpaCategoryRepository.save(entity);
        return CategoryMapper.toDomain(entity);
    }
}
