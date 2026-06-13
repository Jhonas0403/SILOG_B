package com.silog.silog_user.domain.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

public class CashSession {
    private UUID id;
    private UUID storeId;
    private UUID openedBy;
    private UUID closedBy;
    private ZonedDateTime openedAt;
    private ZonedDateTime closedAt;
    private String status;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CashSession() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getStoreId() { return storeId; }
    public void setStoreId(UUID storeId) { this.storeId = storeId; }

    public UUID getOpenedBy() { return openedBy; }
    public void setOpenedBy(UUID openedBy) { this.openedBy = openedBy; }

    public UUID getClosedBy() { return closedBy; }
    public void setClosedBy(UUID closedBy) { this.closedBy = closedBy; }

    public ZonedDateTime getOpenedAt() { return openedAt; }
    public void setOpenedAt(ZonedDateTime openedAt) { this.openedAt = openedAt; }

    public ZonedDateTime getClosedAt() { return closedAt; }
    public void setClosedAt(ZonedDateTime closedAt) { this.closedAt = closedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
