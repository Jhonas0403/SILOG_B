package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.CashSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaCashSessionRepository extends JpaRepository<CashSessionEntity, UUID> {
    Optional<CashSessionEntity> findByStoreIdAndStatus(UUID storeId, String status);
    List<CashSessionEntity> findByStoreIdOrderByOpenedAtDesc(UUID storeId);
}
