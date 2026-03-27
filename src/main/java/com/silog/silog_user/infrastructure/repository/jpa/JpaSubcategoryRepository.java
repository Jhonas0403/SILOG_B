package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaSubcategoryRepository extends JpaRepository<SubcategoryEntity, Integer> {
    List<SubcategoryEntity> findAllByOrderBySubcategoryOrderAsc();
    @Query("SELECT COALESCE(MAX(s.subcategoryOrder), 0) FROM SubcategoryEntity s")
    Integer findMaxSubcategoryOrder();
}
