package com.silog.silog_user.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentMethod {
    private UUID id;
    private String name;
    private String description;
    private Boolean requiresOperationCode;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PaymentMethod() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getRequiresOperationCode() { return requiresOperationCode; }
    public void setRequiresOperationCode(Boolean requiresOperationCode) { this.requiresOperationCode = requiresOperationCode; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
