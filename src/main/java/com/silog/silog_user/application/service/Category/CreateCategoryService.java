package com.silog.silog_user.application.service.Category;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.domain.port.in.Category.CreateCategoryUseCase;
import com.silog.silog_user.domain.port.out.CategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateCategoryService implements CreateCategoryUseCase {
    public final CategoryRepositoryPort categoryRepository;
    public CreateCategoryService(CategoryRepositoryPort categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category create(Category category) {
        Integer nextOrder = categoryRepository.findMaxOrder() + 1;
        if (category.getStatus() == null) {
            category.setStatus(true);
        }

        if(category.getUpdatedBy() == null) {
            category.setUpdatedBy(category.getCreatedBy());
        }

        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        category.setOrder(nextOrder);
        return categoryRepository.save(category);
    }

}
