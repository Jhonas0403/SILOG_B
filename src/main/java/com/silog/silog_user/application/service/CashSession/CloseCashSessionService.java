package com.silog.silog_user.application.service.CashSession;

import com.silog.silog_user.domain.exception.ResourceNotFoundException;
import com.silog.silog_user.domain.model.*;
import com.silog.silog_user.domain.port.in.CashSession.CloseCashSessionUseCase;
import com.silog.silog_user.domain.port.out.CashSessionRepositoryPort;
import com.silog.silog_user.domain.port.out.PaymentMethodRepositoryPort;
import com.silog.silog_user.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CloseCashSessionService implements CloseCashSessionUseCase {

    private final CashSessionRepositoryPort cashSessionRepositoryPort;
    private final SaleRepositoryPort saleRepositoryPort;
    private final PaymentMethodRepositoryPort paymentMethodRepositoryPort;

    public CloseCashSessionService(CashSessionRepositoryPort cashSessionRepositoryPort,
                                   SaleRepositoryPort saleRepositoryPort,
                                   PaymentMethodRepositoryPort paymentMethodRepositoryPort) {
        this.cashSessionRepositoryPort = cashSessionRepositoryPort;
        this.saleRepositoryPort = saleRepositoryPort;
        this.paymentMethodRepositoryPort = paymentMethodRepositoryPort;
    }

    @Override
    public CashSessionReport close(UUID storeId, UUID closedBy, String notes) {
        CashSession session = cashSessionRepositoryPort.findOpenByStoreId(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("No hay una sesión de caja abierta para esta tienda"));

        ZonedDateTime closedAt = ZonedDateTime.now(ZoneId.of("America/Lima"));
        session.setClosedAt(closedAt);
        session.setClosedBy(closedBy);
        session.setStatus("CLOSED");
        session.setNotes(notes);
        cashSessionRepositoryPort.save(session);

        List<CashSessionOpeningAmount> openingAmounts =
                cashSessionRepositoryPort.findOpeningAmountsBySessionId(session.getId());

        Map<UUID, BigDecimal> openingMap = openingAmounts.stream()
                .collect(Collectors.toMap(CashSessionOpeningAmount::getPaymentMethodId, CashSessionOpeningAmount::getAmount));

        Map<UUID, BigDecimal> salesMap = saleRepositoryPort
                .sumTotalByPaymentMethodForStore(storeId, session.getOpenedAt(), closedAt);

        Map<UUID, String> paymentMethodNames = paymentMethodRepositoryPort.findAll().stream()
                .collect(Collectors.toMap(PaymentMethod::getId, PaymentMethod::getName));

        Set<UUID> allMethodIds = new LinkedHashSet<>();
        allMethodIds.addAll(openingMap.keySet());
        allMethodIds.addAll(salesMap.keySet());

        BigDecimal totalSales = BigDecimal.ZERO;
        List<CashSessionReportItem> items = new ArrayList<>();

        for (UUID methodId : allMethodIds) {
            BigDecimal opening = openingMap.getOrDefault(methodId, BigDecimal.ZERO);
            BigDecimal sales = salesMap.getOrDefault(methodId, BigDecimal.ZERO);

            CashSessionReportItem item = new CashSessionReportItem();
            item.setPaymentMethodId(methodId);
            item.setPaymentMethodName(paymentMethodNames.getOrDefault(methodId, "DESCONOCIDO"));
            item.setOpeningAmount(opening);
            item.setSalesTotal(sales);
            item.setExpectedTotal(opening.add(sales));
            items.add(item);

            totalSales = totalSales.add(sales);
        }

        CashSessionReport report = new CashSessionReport();
        report.setSessionId(session.getId());
        report.setStoreId(storeId);
        report.setOpenedAt(session.getOpenedAt());
        report.setClosedAt(closedAt);
        report.setOpenedBy(session.getOpenedBy());
        report.setClosedBy(closedBy);
        report.setNotes(notes);
        report.setItems(items);
        report.setTotalSales(totalSales);
        return report;
    }
}
