package com.silog.silog_user.application.service.CashSession;

import com.silog.silog_user.domain.exception.ResourceNotFoundException;
import com.silog.silog_user.domain.model.CashSession;
import com.silog.silog_user.domain.port.in.CashSession.GetCurrentCashSessionUseCase;
import com.silog.silog_user.domain.port.out.CashSessionRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetCurrentCashSessionService implements GetCurrentCashSessionUseCase {

    private final CashSessionRepositoryPort cashSessionRepositoryPort;

    public GetCurrentCashSessionService(CashSessionRepositoryPort cashSessionRepositoryPort) {
        this.cashSessionRepositoryPort = cashSessionRepositoryPort;
    }

    @Override
    public CashSession getCurrent(UUID storeId) {
        return cashSessionRepositoryPort.findOpenByStoreId(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("No hay una sesión de caja abierta para esta tienda"));
    }
}
