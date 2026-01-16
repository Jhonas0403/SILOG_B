package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Category;

import java.util.List;

public interface CategoryRepositoryPort {
    List<Category> findAll();
    Category save(Category category);
}
