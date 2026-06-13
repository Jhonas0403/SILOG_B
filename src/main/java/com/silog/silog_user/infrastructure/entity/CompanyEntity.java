package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class CompanyEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "company_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "company_name", nullable = false, unique = true, length = 255)
    private String name;

    @Column(name = "company_ruc", unique = true, length = 20)
    private String ruc;

    @Column(name = "company_address", length = 255)
    private String address;

    @Column(name = "company_phone", nullable = false, unique = true, length = 50)
    private String phone;

    @Column(name = "company_description", length = 255)
    private String description;

    @Column(name = "company_status", nullable = false)
    private Boolean status;
}
