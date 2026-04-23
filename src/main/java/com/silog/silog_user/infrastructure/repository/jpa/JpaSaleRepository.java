package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaSaleRepository extends JpaRepository<SaleEntity, UUID> {
    List<SaleEntity> findAllByOrderBySaleDateDesc();
}
