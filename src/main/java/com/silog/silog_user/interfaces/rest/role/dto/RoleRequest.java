package com.silog.silog_user.interfaces.rest.role.dto;

import com.silog.silog_user.domain.model.Role;
import jakarta.validation.constraints.NotBlank;

public class RoleRequest {

    @NotBlank(message = "El nombre del rol es requerido")
    private String name;

    private String description;

    private Boolean status;

    public Role toDomain() {
        Role role = new Role();
        role.setName(name.toUpperCase().trim());
        role.setDescription(description);
        role.setStatus(status);
        return role;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
