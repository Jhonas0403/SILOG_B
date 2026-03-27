package com.silog.silog_user.domain.port.in.Subcategory;

import com.silog.silog_user.domain.model.Subcategory;

public interface CreateSubcategoryUseCase {

    Subcategory create(Subcategory subcategory);
}
