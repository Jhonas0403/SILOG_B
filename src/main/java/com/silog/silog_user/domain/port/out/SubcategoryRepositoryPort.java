package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Subcategory;

import java.util.List;

public interface SubcategoryRepositoryPort {

    List<Subcategory> findAll();
    Subcategory save(Subcategory subcategory);
    Integer findMaxOrder();
    /*Subcategory findById(long id);?*/
}
