package com.silog.silog_user.application.service.CashSession;

import com.silog.silog_user.domain.exception.ConflictException;
import com.silog.silog_user.domain.model.CashSession;
import com.silog.silog_user.domain.model.CashSessionOpeningAmount;
import com.silog.silog_user.domain.port.in.CashSession.OpenCashSessionUseCase;
import com.silog.silog_user.domain.port.out.CashSessionRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class OpenCashSessionService implements OpenCashSessionUseCase {

    private final CashSessionRepositoryPort cashSessionRepositoryPort;

    public OpenCashSessionService(CashSessionRepositoryPort cashSessionRepositoryPort) {
        this.cashSessionRepositoryPort = cashSessionRepositoryPort;
    }

    @Override
    public CashSession open(CashSession session, List<CashSessionOpeningAmount> openingAmounts) {
        if (session.getStoreId() == null) {
            throw new IllegalArgumentException("El usuario no tiene una tienda asignada");
        }
        cashSessionRepositoryPort.findOpenByStoreId(session.getStoreId()).ifPresent(existing -> {
            throw new ConflictException("Ya existe una sesión de caja abierta para esta tienda");
        });

        session.setStatus("OPEN");
        session.setOpenedAt(ZonedDateTime.now(ZoneId.of("America/Lima")));
        CashSession saved = cashSessionRepositoryPort.save(session);

        openingAmounts.forEach(oa -> oa.setCashSessionId(saved.getId()));
        cashSessionRepositoryPort.saveOpeningAmounts(openingAmounts);

        return saved;
    }
}
