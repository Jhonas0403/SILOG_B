package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Variant;
import com.silog.silog_user.domain.port.out.VariantRepositoryPort;
import com.silog.silog_user.infrastructure.entity.VariantEntity;
import com.silog.silog_user.infrastructure.mapper.VariantMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaVariantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class VariantRepositoryAdapter implements VariantRepositoryPort {
    private final JpaVariantRepository jpaVariantRepository;

    public VariantRepositoryAdapter(JpaVariantRepository jpaVariantRepository) {
        this.jpaVariantRepository = jpaVariantRepository;
    }

    @Override
    public List<Variant> findAll() {
        List<VariantEntity> variants = jpaVariantRepository.findAllByOrderByVariantOrderAsc();
        return variants.stream().map(VariantMapper::toDomain).toList();
    }

    @Override
    public Variant save(Variant variant) {
        VariantEntity variantEntity = VariantMapper.toEntity(variant);
        variantEntity = jpaVariantRepository.save(variantEntity);
        return VariantMapper.toDomain(variantEntity);
    }

    @Override
    public Variant findById(UUID id) {
        return jpaVariantRepository.findById(id)
                .map(VariantMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Integer findMaxOrder(){
        return jpaVariantRepository.findMaxVariantOrder();
    }

}
