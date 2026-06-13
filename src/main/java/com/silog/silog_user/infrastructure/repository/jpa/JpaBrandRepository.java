package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaBrandRepository extends JpaRepository<BrandEntity, UUID> {
    List<BrandEntity> findAllByOrderByBrandOrderAsc();
    List<BrandEntity> findByStoreIdOrderByBrandOrderAsc(UUID storeId);

    @Query("SELECT COALESCE(MAX(b.brandOrder), 0) FROM BrandEntity b WHERE b.storeId = :storeId")
    Integer findMaxBrandOrderByStoreId(@org.springframework.data.repository.query.Param("storeId") UUID storeId);
}
