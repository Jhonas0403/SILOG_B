package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.VariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaVariantRepository extends JpaRepository<VariantEntity, UUID> {
    List<VariantEntity> findAllByOrderByVariantOrderAsc();
    List<VariantEntity> findByStoreIdOrderByVariantOrderAsc(UUID storeId);

    @Query("SELECT COALESCE(MAX(v.variantOrder), 0) FROM VariantEntity v WHERE v.storeId = :storeId")
    Integer findMaxVariantOrderByStoreId(@org.springframework.data.repository.query.Param("storeId") UUID storeId);
}
