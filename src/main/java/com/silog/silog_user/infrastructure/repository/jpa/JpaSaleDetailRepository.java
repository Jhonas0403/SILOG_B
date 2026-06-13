package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.SaleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface JpaSaleDetailRepository extends JpaRepository<SaleDetailEntity, UUID> {
    List<SaleDetailEntity> findAllByOrderByCreatedAtDesc();

    @Query("SELECT sd FROM SaleDetailEntity sd " +
           "JOIN SaleEntity s ON sd.saleId = s.id " +
           "WHERE s.storeId = :storeId " +
           "ORDER BY sd.createdAt DESC")
    List<SaleDetailEntity> findByStoreIdOrderByCreatedAtDesc(@Param("storeId") UUID storeId);
}
