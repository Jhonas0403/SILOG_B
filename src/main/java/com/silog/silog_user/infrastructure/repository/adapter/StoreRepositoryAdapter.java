package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Store;
import com.silog.silog_user.domain.port.out.StoreRepositoryPort;
import com.silog.silog_user.infrastructure.mapper.StoreMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaStoreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class StoreRepositoryAdapter implements StoreRepositoryPort {

    private final JpaStoreRepository jpaStoreRepository;

    public StoreRepositoryAdapter(JpaStoreRepository jpaStoreRepository) {
        this.jpaStoreRepository = jpaStoreRepository;
    }

    @Override
    public Store save(Store store) {
        return StoreMapper.toDomain(jpaStoreRepository.save(StoreMapper.toEntity(store)));
    }

    @Override
    public List<Store> findAll() {
        return jpaStoreRepository.findAll().stream().map(StoreMapper::toDomain).toList();
    }

    @Override
    public List<Store> findByCompanyId(UUID companyId) {
        return jpaStoreRepository.findByCompanyId(companyId).stream().map(StoreMapper::toDomain).toList();
    }

    @Override
    public Optional<Store> findById(UUID id) {
        return jpaStoreRepository.findById(id).map(StoreMapper::toDomain);
    }
}
