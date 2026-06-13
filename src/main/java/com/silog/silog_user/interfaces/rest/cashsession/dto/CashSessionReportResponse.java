package com.silog.silog_user.interfaces.rest.cashsession.dto;

import com.silog.silog_user.domain.model.CashSessionReport;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class CashSessionReportResponse {
    private UUID sessionId;
    private UUID storeId;
    private ZonedDateTime openedAt;
    private ZonedDateTime closedAt;
    private UUID openedBy;
    private UUID closedBy;
    private String notes;
    private List<CashSessionReportItemResponse> items;
    private BigDecimal totalSales;

    public static CashSessionReportResponse fromDomain(CashSessionReport report) {
        CashSessionReportResponse dto = new CashSessionReportResponse();
        dto.sessionId = report.getSessionId();
        dto.storeId = report.getStoreId();
        dto.openedAt = report.getOpenedAt();
        dto.closedAt = report.getClosedAt();
        dto.openedBy = report.getOpenedBy();
        dto.closedBy = report.getClosedBy();
        dto.notes = report.getNotes();
        dto.totalSales = report.getTotalSales();
        dto.items = report.getItems().stream()
                .map(CashSessionReportItemResponse::fromDomain)
                .toList();
        return dto;
    }

    public UUID getSessionId() { return sessionId; }
    public UUID getStoreId() { return storeId; }
    public ZonedDateTime getOpenedAt() { return openedAt; }
    public ZonedDateTime getClosedAt() { return closedAt; }
    public UUID getOpenedBy() { return openedBy; }
    public UUID getClosedBy() { return closedBy; }
    public String getNotes() { return notes; }
    public List<CashSessionReportItemResponse> getItems() { return items; }
    public BigDecimal getTotalSales() { return totalSales; }
}
