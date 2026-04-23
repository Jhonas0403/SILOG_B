package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.InventoryMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaInventoryMovementRepository extends JpaRepository<InventoryMovementEntity, UUID> {
    List<InventoryMovementEntity> findAllByOrderByCreatedAtDesc();
}
