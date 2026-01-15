package com.silog.silog_user.domain.port.in.Category;

import com.silog.silog_user.domain.model.Category;

import java.util.List;

public interface GetCategoryUseCase {
    List<Category> getCategories();
}
