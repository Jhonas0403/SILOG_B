package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.SaleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaSaleDetailRepository extends JpaRepository<SaleDetailEntity, UUID> {
    List<SaleDetailEntity> findAllByOrderByCreatedAtDesc();
}
