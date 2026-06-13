package com.silog.silog_user.infrastructure.repository.adapter;

import com.silog.silog_user.domain.model.CashSession;
import com.silog.silog_user.domain.model.CashSessionOpeningAmount;
import com.silog.silog_user.domain.port.out.CashSessionRepositoryPort;
import com.silog.silog_user.infrastructure.entity.CashSessionEntity;
import com.silog.silog_user.infrastructure.mapper.CashSessionMapper;
import com.silog.silog_user.infrastructure.repository.jpa.JpaCashSessionOpeningAmountRepository;
import com.silog.silog_user.infrastructure.repository.jpa.JpaCashSessionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CashSessionRepositoryAdapter implements CashSessionRepositoryPort {

    private final JpaCashSessionRepository jpaCashSessionRepository;
    private final JpaCashSessionOpeningAmountRepository jpaOpeningAmountRepository;

    public CashSessionRepositoryAdapter(JpaCashSessionRepository jpaCashSessionRepository,
                                        JpaCashSessionOpeningAmountRepository jpaOpeningAmountRepository) {
        this.jpaCashSessionRepository = jpaCashSessionRepository;
        this.jpaOpeningAmountRepository = jpaOpeningAmountRepository;
    }

    @Override
    public CashSession save(CashSession session) {
        CashSessionEntity entity = CashSessionMapper.toEntity(session);
        return CashSessionMapper.toDomain(jpaCashSessionRepository.save(entity));
    }

    @Override
    public Optional<CashSession> findOpenByStoreId(UUID storeId) {
        return jpaCashSessionRepository.findByStoreIdAndStatus(storeId, "OPEN")
                .map(CashSessionMapper::toDomain);
    }

    @Override
    public Optional<CashSession> findById(UUID id) {
        return jpaCashSessionRepository.findById(id)
                .map(CashSessionMapper::toDomain);
    }

    @Override
    public void saveOpeningAmounts(List<CashSessionOpeningAmount> amounts) {
        jpaOpeningAmountRepository.saveAll(
                amounts.stream().map(CashSessionMapper::toAmountEntity).toList()
        );
    }

    @Override
    public List<CashSessionOpeningAmount> findOpeningAmountsBySessionId(UUID sessionId) {
        return jpaOpeningAmountRepository.findByCashSessionId(sessionId)
                .stream()
                .map(CashSessionMapper::toAmountDomain)
                .toList();
    }

    @Override
    public List<CashSession> findByStoreId(UUID storeId) {
        return jpaCashSessionRepository.findByStoreIdOrderByOpenedAtDesc(storeId)
                .stream()
                .map(CashSessionMapper::toDomain)
                .toList();
    }
}
