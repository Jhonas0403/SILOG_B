package com.silog.silog_user.domain.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class CashSessionReport {
    private UUID sessionId;
    private UUID storeId;
    private ZonedDateTime openedAt;
    private ZonedDateTime closedAt;
    private UUID openedBy;
    private UUID closedBy;
    private String notes;
    private List<CashSessionReportItem> items;
    private BigDecimal totalSales;

    public CashSessionReport() {}

    public UUID getSessionId() { return sessionId; }
    public void setSessionId(UUID sessionId) { this.sessionId = sessionId; }

    public UUID getStoreId() { return storeId; }
    public void setStoreId(UUID storeId) { this.storeId = storeId; }

    public ZonedDateTime getOpenedAt() { return openedAt; }
    public void setOpenedAt(ZonedDateTime openedAt) { this.openedAt = openedAt; }

    public ZonedDateTime getClosedAt() { return closedAt; }
    public void setClosedAt(ZonedDateTime closedAt) { this.closedAt = closedAt; }

    public UUID getOpenedBy() { return openedBy; }
    public void setOpenedBy(UUID openedBy) { this.openedBy = openedBy; }

    public UUID getClosedBy() { return closedBy; }
    public void setClosedBy(UUID closedBy) { this.closedBy = closedBy; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public List<CashSessionReportItem> getItems() { return items; }
    public void setItems(List<CashSessionReportItem> items) { this.items = items; }

    public BigDecimal getTotalSales() { return totalSales; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
}
