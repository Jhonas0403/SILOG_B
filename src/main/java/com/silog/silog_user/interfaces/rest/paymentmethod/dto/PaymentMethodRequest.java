package com.silog.silog_user.interfaces.rest.paymentmethod.dto;

import com.silog.silog_user.domain.model.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PaymentMethodRequest {

    @NotBlank(message = "El nombre es requerido")
    private String name;

    private String description;

    @NotNull(message = "Se debe indicar si requiere código de operación")
    private Boolean requiresOperationCode;

    public PaymentMethod toDomain() {
        PaymentMethod pm = new PaymentMethod();
        pm.setName(name.toUpperCase().trim());
        pm.setDescription(description);
        pm.setRequiresOperationCode(requiresOperationCode);
        return pm;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getRequiresOperationCode() { return requiresOperationCode; }
    public void setRequiresOperationCode(Boolean requiresOperationCode) { this.requiresOperationCode = requiresOperationCode; }
}
