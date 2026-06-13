package com.silog.silog_user.interfaces.rest.paymentmethod.dto;

import com.silog.silog_user.domain.model.PaymentMethod;

import java.util.UUID;

public class PaymentMethodResponse {

    private UUID id;
    private String name;
    private String description;
    private Boolean requiresOperationCode;
    private Boolean status;

    public static PaymentMethodResponse fromDomain(PaymentMethod pm) {
        if (pm == null) return null;
        PaymentMethodResponse response = new PaymentMethodResponse();
        response.setId(pm.getId());
        response.setName(pm.getName());
        response.setDescription(pm.getDescription());
        response.setRequiresOperationCode(pm.getRequiresOperationCode());
        response.setStatus(pm.getStatus());
        return response;
    }

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
}
