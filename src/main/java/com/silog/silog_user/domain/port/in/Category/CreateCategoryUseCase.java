package com.silog.silog_user.domain.port.in.Category;

import com.silog.silog_user.domain.model.Category;

public interface CreateCategoryUseCase {
    Category create(Category category);
}
