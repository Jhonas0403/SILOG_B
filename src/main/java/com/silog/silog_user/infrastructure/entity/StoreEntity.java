package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "stores")
@Getter
@Setter
@NoArgsConstructor
public class StoreEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "store_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;

    @Column(name = "store_name", nullable = false, length = 255)
    private String name;

    @Column(name = "store_address", length = 255)
    private String address;

    @Column(name = "store_phone", length = 50)
    private String phone;

    @Column(name = "store_status", nullable = false)
    private Boolean status;
}
