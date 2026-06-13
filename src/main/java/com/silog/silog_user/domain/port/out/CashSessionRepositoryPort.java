package com.silog.silog_user.domain.port.out;

import com.silog.silog_user.domain.model.CashSession;
import com.silog.silog_user.domain.model.CashSessionOpeningAmount;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CashSessionRepositoryPort {
    CashSession save(CashSession session);
    Optional<CashSession> findOpenByStoreId(UUID storeId);
    Optional<CashSession> findById(UUID id);
    List<CashSession> findByStoreId(UUID storeId);
    void saveOpeningAmounts(List<CashSessionOpeningAmount> amounts);
    List<CashSessionOpeningAmount> findOpeningAmountsBySessionId(UUID sessionId);
}
