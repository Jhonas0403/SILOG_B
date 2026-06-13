package com.silog.silog_user.interfaces.rest.company.dto;

import com.silog.silog_user.domain.model.Company;
import jakarta.validation.constraints.NotBlank;

public class CompanyRequest {

    @NotBlank(message = "El nombre de la empresa es requerido")
    private String name;

    private String ruc;

    private String address;

    @NotBlank(message = "El teléfono es requerido")
    private String phone;

    private String description;

    public Company toDomain() {
        Company company = new Company();
        company.setName(name);
        company.setRuc(ruc);
        company.setAddress(address);
        company.setPhone(phone);
        company.setDescription(description);
        return company;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
