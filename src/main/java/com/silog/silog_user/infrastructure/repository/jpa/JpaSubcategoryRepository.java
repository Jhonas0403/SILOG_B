package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaSubcategoryRepository extends JpaRepository<SubcategoryEntity, UUID> {
    List<SubcategoryEntity> findAllByOrderBySubcategoryOrderAsc();
    List<SubcategoryEntity> findByStoreIdOrderBySubcategoryOrderAsc(UUID storeId);

    @Query("SELECT COALESCE(MAX(s.subcategoryOrder), 0) FROM SubcategoryEntity s WHERE s.storeId = :storeId")
    Integer findMaxSubcategoryOrderByStoreId(@org.springframework.data.repository.query.Param("storeId") UUID storeId);
}
