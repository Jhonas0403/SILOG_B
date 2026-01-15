package com.silog.silog_user.application.service.Category;

import com.silog.silog_user.domain.model.Category;
import com.silog.silog_user.domain.port.in.Category.GetCategoryUseCase;
import com.silog.silog_user.domain.port.out.CategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCategoryService  implements GetCategoryUseCase {
    public final CategoryRepositoryPort categoryRepositoryPort;

    public GetCategoryService(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepositoryPort.findAll();
    }
}
