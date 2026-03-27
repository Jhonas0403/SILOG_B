package com.silog.silog_user.domain.port.in.Subcategory;

import com.silog.silog_user.domain.model.Subcategory;

import java.util.List;

public interface GetSubcategoryUseCase {
    List<Subcategory> getSubcategories();
}
