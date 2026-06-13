package com.silog.silog_user.interfaces.rest.company.dto;

import com.silog.silog_user.domain.model.Company;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompanyResponse {

    private UUID id;
    private String name;
    private String ruc;
    private String address;
    private String phone;
    private String description;
    private Boolean status;
    private LocalDateTime createdAt;

    public static CompanyResponse fromDomain(Company company) {
        if (company == null) return null;
        CompanyResponse dto = new CompanyResponse();
        dto.id = company.getId();
        dto.name = company.getName();
        dto.ruc = company.getRuc();
        dto.address = company.getAddress();
        dto.phone = company.getPhone();
        dto.description = company.getDescription();
        dto.status = company.getStatus();
        dto.createdAt = company.getCreatedAt();
        return dto;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getRuc() { return ruc; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getDescription() { return description; }
    public Boolean getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
