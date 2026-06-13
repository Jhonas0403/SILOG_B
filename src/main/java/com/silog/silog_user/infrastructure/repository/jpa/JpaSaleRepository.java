package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface JpaSaleRepository extends JpaRepository<SaleEntity, UUID> {

    List<SaleEntity> findAllByOrderBySaleDateDesc();

    List<SaleEntity> findByStoreIdOrderBySaleDateDesc(UUID storeId);

    @Query("SELECT s.paymentMethodId AS paymentMethodId, SUM(s.total) AS total " +
           "FROM SaleEntity s " +
           "WHERE s.storeId = :storeId " +
           "AND s.saleDate >= :from " +
           "AND s.saleDate < :to " +
           "GROUP BY s.paymentMethodId")
    List<PaymentMethodSalesProjection> sumTotalByPaymentMethod(
            @Param("storeId") UUID storeId,
            @Param("from") ZonedDateTime from,
            @Param("to") ZonedDateTime to
    );
}
