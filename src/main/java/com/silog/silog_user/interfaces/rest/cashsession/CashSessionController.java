package com.silog.silog_user.interfaces.rest.cashsession;

import com.silog.silog_user.domain.model.CashSession;
import com.silog.silog_user.domain.model.CashSessionOpeningAmount;
import com.silog.silog_user.domain.model.CashSessionReport;
import com.silog.silog_user.domain.port.in.CashSession.CloseCashSessionUseCase;
import com.silog.silog_user.domain.port.in.CashSession.GetCashSessionsUseCase;
import com.silog.silog_user.domain.port.in.CashSession.GetCurrentCashSessionUseCase;
import com.silog.silog_user.domain.port.in.CashSession.OpenCashSessionUseCase;
import com.silog.silog_user.infrastructure.security.UserPrincipal;
import com.silog.silog_user.interfaces.rest.cashsession.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cash-sessions")
public class CashSessionController {

    private final OpenCashSessionUseCase openCashSessionUseCase;
    private final CloseCashSessionUseCase closeCashSessionUseCase;
    private final GetCurrentCashSessionUseCase getCurrentCashSessionUseCase;
    private final GetCashSessionsUseCase getCashSessionsUseCase;

    public CashSessionController(OpenCashSessionUseCase openCashSessionUseCase,
                                 CloseCashSessionUseCase closeCashSessionUseCase,
                                 GetCurrentCashSessionUseCase getCurrentCashSessionUseCase,
                                 GetCashSessionsUseCase getCashSessionsUseCase) {
        this.openCashSessionUseCase = openCashSessionUseCase;
        this.closeCashSessionUseCase = closeCashSessionUseCase;
        this.getCurrentCashSessionUseCase = getCurrentCashSessionUseCase;
        this.getCashSessionsUseCase = getCashSessionsUseCase;
    }

    @PostMapping("/open")
    public ResponseEntity<CashSessionResponse> open(@Valid @RequestBody OpenCashSessionRequest request) {
        UserPrincipal principal = getPrincipal();

        CashSession session = new CashSession();
        session.setStoreId(principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null);
        session.setOpenedBy(UUID.fromString(principal.getUserId()));

        List<CashSessionOpeningAmount> openingAmounts = request.getOpeningAmounts().stream()
                .map(dto -> {
                    CashSessionOpeningAmount oa = new CashSessionOpeningAmount();
                    oa.setPaymentMethodId(dto.getPaymentMethodId());
                    oa.setAmount(dto.getAmount());
                    return oa;
                }).toList();

        CashSession opened = openCashSessionUseCase.open(session, openingAmounts);
        return ResponseEntity.status(HttpStatus.CREATED).body(CashSessionResponse.fromDomain(opened));
    }

    @PostMapping("/close")
    public ResponseEntity<CashSessionReportResponse> close(
            @RequestBody(required = false) CloseSessionRequest request) {
        UserPrincipal principal = getPrincipal();
        UUID storeId = principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
        UUID closedBy = UUID.fromString(principal.getUserId());
        String notes = request != null ? request.getNotes() : null;

        CashSessionReport report = closeCashSessionUseCase.close(storeId, closedBy, notes);
        return ResponseEntity.ok(CashSessionReportResponse.fromDomain(report));
    }

    @GetMapping("/current")
    public ResponseEntity<CashSessionResponse> getCurrent() {
        UserPrincipal principal = getPrincipal();
        UUID storeId = principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
        CashSession session = getCurrentCashSessionUseCase.getCurrent(storeId);
        return ResponseEntity.ok(CashSessionResponse.fromDomain(session));
    }

    @GetMapping
    public ResponseEntity<List<CashSession>> getSessions() {
        UserPrincipal principal = getPrincipal();
        UUID storeId = principal.getStoreId() != null ? UUID.fromString(principal.getStoreId()) : null;
        List<CashSession> sessions = getCashSessionsUseCase.getSessions(storeId);
        return ResponseEntity.ok(sessions);
    }

    private UserPrincipal getPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (UserPrincipal) auth.getPrincipal();
    }
}
