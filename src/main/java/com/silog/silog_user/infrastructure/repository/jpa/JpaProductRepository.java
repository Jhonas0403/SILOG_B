package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaProductRepository extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findAllByOrderByProductOrderAsc();
    List<ProductEntity> findByStoreIdOrderByProductOrderAsc(UUID storeId);

    @Query("SELECT COALESCE(MAX(p.productOrder), 0) FROM ProductEntity p WHERE p.storeId = :storeId")
    Integer findMaxProductOrderByStoreId(@org.springframework.data.repository.query.Param("storeId") UUID storeId);
}
