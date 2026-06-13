package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.Store;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StoreRepositoryPort {
    Store save(Store store);
    List<Store> findAll();
    List<Store> findByCompanyId(UUID companyId);
    Optional<Store> findById(UUID id);
}
