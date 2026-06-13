package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.Sale;
import com.silog.silog_user.domain.port.out.SaleRepositoryPort;
import com.silog.silog_user.infrastructure.entity.SaleEntity;
import com.silog.silog_user.infrastructure.mapper.SaleMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaSaleRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class SaleRepositoryAdapter implements SaleRepositoryPort {
    private final JpaSaleRepository jpaSaleRepository;

    public SaleRepositoryAdapter(JpaSaleRepository jpaSaleRepository) {
        this.jpaSaleRepository = jpaSaleRepository;
    }

    @Override
    public Sale save(Sale sale) {
        SaleEntity entity = SaleMapper.toEntity(sale);
        return SaleMapper.toDomain(jpaSaleRepository.save(entity));
    }

    @Override
    public List<Sale> findAll() {
        return jpaSaleRepository.findAllByOrderBySaleDateDesc()
                .stream()
                .map(SaleMapper::toDomain)
                .toList();
    }

    @Override
    public Sale findById(UUID id) {
        return jpaSaleRepository.findById(id)
                .map(SaleMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Sale> findByStoreId(UUID storeId) {
        return jpaSaleRepository.findByStoreIdOrderBySaleDateDesc(storeId)
                .stream()
                .map(SaleMapper::toDomain)
                .toList();
    }

    @Override
    public Map<UUID, BigDecimal> sumTotalByPaymentMethodForStore(UUID storeId, ZonedDateTime from, ZonedDateTime to) {
        return jpaSaleRepository.sumTotalByPaymentMethod(storeId, from, to)
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getPaymentMethodId(),
                        p -> p.getTotal()
                ));
    }
}
