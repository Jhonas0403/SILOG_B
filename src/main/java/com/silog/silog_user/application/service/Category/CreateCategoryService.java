package com.silog.silog_user.application.service.Category;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.domain.port.in.Category.CreateCategoryUseCase;
import com.silog.silog_user.domain.port.out.CategoryRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService implements CreateCategoryUseCase {
    public final CategoryRepositoryPort categoryRepository;
    public CreateCategoryService(CategoryRepositoryPort categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

}
