package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.InventoryMovement;
import com.silog.silog_user.domain.port.out.InventoryMovementRepositoryPort;
import com.silog.silog_user.infrastructure.entity.InventoryMovementEntity;
import com.silog.silog_user.infrastructure.mapper.InventoryMovementMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaInventoryMovementRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class InventoryMovementRepositoryAdapter implements InventoryMovementRepositoryPort {
    private final JpaInventoryMovementRepository jpaInventoryMovementRepository;

    public InventoryMovementRepositoryAdapter(JpaInventoryMovementRepository jpaInventoryMovementRepository) {
        this.jpaInventoryMovementRepository = jpaInventoryMovementRepository;
    }

    @Override
    public InventoryMovement save(InventoryMovement inventoryMovement) {
        InventoryMovementEntity entity = InventoryMovementMapper.toEntity(inventoryMovement);
        return InventoryMovementMapper.toDomain(jpaInventoryMovementRepository.save(entity));
    }

    @Override
    public List<InventoryMovement> findAll() {
        return jpaInventoryMovementRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(InventoryMovementMapper::toDomain)
                .toList();
    }

    @Override
    public InventoryMovement findById(UUID id) {
        return jpaInventoryMovementRepository.findById(id)
                .map(InventoryMovementMapper::toDomain)
                .orElse(null);
    }
}
