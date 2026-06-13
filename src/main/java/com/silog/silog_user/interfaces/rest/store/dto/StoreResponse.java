package com.silog.silog_user.interfaces.rest.store.dto;

import com.silog.silog_user.domain.model.Store;

import java.time.LocalDateTime;
import java.util.UUID;

public class StoreResponse {

    private UUID id;
    private UUID companyId;
    private String name;
    private String address;
    private String phone;
    private Boolean status;
    private LocalDateTime createdAt;

    public static StoreResponse fromDomain(Store store) {
        if (store == null) return null;
        StoreResponse dto = new StoreResponse();
        dto.id = store.getId();
        dto.companyId = store.getCompanyId();
        dto.name = store.getName();
        dto.address = store.getAddress();
        dto.phone = store.getPhone();
        dto.status = store.getStatus();
        dto.createdAt = store.getCreatedAt();
        return dto;
    }

    public UUID getId() { return id; }
    public UUID getCompanyId() { return companyId; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public Boolean getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
