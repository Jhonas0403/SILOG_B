package com.silog.silog_user.interfaces.rest.cashsession.dto;

import com.silog.silog_user.domain.model.CashSession;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CashSessionResponse {
    private UUID id;
    private UUID storeId;
    private UUID openedBy;
    private UUID closedBy;
    private ZonedDateTime openedAt;
    private ZonedDateTime closedAt;
    private String status;
    private String notes;

    public static CashSessionResponse fromDomain(CashSession session) {
        if (session == null) return null;
        CashSessionResponse dto = new CashSessionResponse();
        dto.id = session.getId();
        dto.storeId = session.getStoreId();
        dto.openedBy = session.getOpenedBy();
        dto.closedBy = session.getClosedBy();
        dto.openedAt = session.getOpenedAt();
        dto.closedAt = session.getClosedAt();
        dto.status = session.getStatus();
        dto.notes = session.getNotes();
        return dto;
    }

    public UUID getId() { return id; }
    public UUID getStoreId() { return storeId; }
    public UUID getOpenedBy() { return openedBy; }
    public UUID getClosedBy() { return closedBy; }
    public ZonedDateTime getOpenedAt() { return openedAt; }
    public ZonedDateTime getClosedAt() { return closedAt; }
    public String getStatus() { return status; }
    public String getNotes() { return notes; }
}
