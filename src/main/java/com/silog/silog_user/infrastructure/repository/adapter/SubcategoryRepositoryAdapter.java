package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Subcategory;
import com.silog.silog_user.domain.port.out.SubcategoryRepositoryPort;
import com.silog.silog_user.infrastructure.entity.SubcategoryEntity;
import com.silog.silog_user.infrastructure.mapper.SubcategoryMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaSubcategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubcategoryRepositoryAdapter implements SubcategoryRepositoryPort {
    private final JpaSubcategoryRepository jpaRepository;

    public SubcategoryRepositoryAdapter(JpaSubcategoryRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    @Override
    public List<Subcategory>findAll() {
        List<SubcategoryEntity> subcategories = jpaRepository.findAllByOrderBySubcategoryOrderAsc();
        return subcategories.stream().map(SubcategoryMapper::toDomain).toList();
    }
    @Override
    public Subcategory save(Subcategory subcategory) {
        SubcategoryEntity subcategoryEntity = SubcategoryMapper.toEntity(subcategory);
        subcategoryEntity = jpaRepository.save(subcategoryEntity);
        return SubcategoryMapper.toDomain(subcategoryEntity);
    }

    @Override
    public Integer findMaxOrder() {
        return jpaRepository.findMaxSubcategoryOrder();
    }
}
