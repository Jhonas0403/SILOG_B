package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaBrandRepository extends JpaRepository<BrandEntity, UUID> {
}
