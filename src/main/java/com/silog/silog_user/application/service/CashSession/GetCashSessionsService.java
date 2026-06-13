package com.silog.silog_user.application.service.CashSession;

import com.silog.silog_user.domain.model.CashSession;
import com.silog.silog_user.domain.port.in.CashSession.GetCashSessionsUseCase;
import com.silog.silog_user.domain.port.out.CashSessionRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetCashSessionsService implements GetCashSessionsUseCase {
    private final CashSessionRepositoryPort cashSessionRepositoryPort;

    public GetCashSessionsService(CashSessionRepositoryPort cashSessionRepositoryPort) {
        this.cashSessionRepositoryPort = cashSessionRepositoryPort;
    }

    @Override
    public List<CashSession> getSessions(UUID storeId) {
        if (storeId != null) {
            return cashSessionRepositoryPort.findByStoreId(storeId);
        }
        return List.of();
    }
}
