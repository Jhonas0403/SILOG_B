package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.SaleDetail;
import com.silog.silog_user.domain.port.out.SaleDetailRepositoryPort;
import com.silog.silog_user.infrastructure.entity.SaleDetailEntity;
import com.silog.silog_user.infrastructure.mapper.SaleDetailMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaSaleDetailRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SaleDetailRepositoryAdapter implements SaleDetailRepositoryPort {
    private final JpaSaleDetailRepository jpaSaleDetailRepository;

    public SaleDetailRepositoryAdapter(JpaSaleDetailRepository jpaSaleDetailRepository) {
        this.jpaSaleDetailRepository = jpaSaleDetailRepository;
    }

    @Override
    public SaleDetail save(SaleDetail saleDetail) {
        SaleDetailEntity entity = SaleDetailMapper.toEntity(saleDetail);
        return SaleDetailMapper.toDomain(jpaSaleDetailRepository.save(entity));
    }

    @Override
    public List<SaleDetail> findAll() {
        return jpaSaleDetailRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(SaleDetailMapper::toDomain)
                .toList();
    }

    @Override
    public SaleDetail findById(UUID id) {
        return jpaSaleDetailRepository.findById(id)
                .map(SaleDetailMapper::toDomain)
                .orElse(null);
    }
}
