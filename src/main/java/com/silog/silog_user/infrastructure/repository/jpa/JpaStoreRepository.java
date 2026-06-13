package com.silog.silog_user.infrastructure.repository.jpa;

import com.silog.silog_user.infrastructure.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaStoreRepository extends JpaRepository<StoreEntity, UUID> {
    List<StoreEntity> findByCompanyId(UUID companyId);
}
