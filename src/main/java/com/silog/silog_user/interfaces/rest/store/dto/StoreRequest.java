package com.silog.silog_user.interfaces.rest.store.dto;

import com.silog.silog_user.domain.model.Store;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class StoreRequest {

    private UUID companyId;

    @NotBlank(message = "El nombre de la tienda es requerido")
    private String name;

    private String address;

    private String phone;

    public Store toDomain() {
        Store store = new Store();
        store.setCompanyId(companyId);
        store.setName(name);
        store.setAddress(address);
        store.setPhone(phone);
        return store;
    }

    public UUID getCompanyId() { return companyId; }
    public void setCompanyId(UUID companyId) { this.companyId = companyId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
