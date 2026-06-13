package com.silog.silog_user.domain.port.in.Category;

import com.silog.silog_user.domain.model.Category;

import java.util.List;
import java.util.UUID;

public interface GetCategoryUseCase {
    List<Category> getCategories(UUID storeId);
}
