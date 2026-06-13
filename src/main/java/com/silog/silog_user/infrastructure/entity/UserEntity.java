package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Fixes applied:
 * - Added @Getter/@Setter/@NoArgsConstructor (Lombok) — removes ~40 lines of manual code
 * - Extends AuditableEntity — adds created_at, updated_at, created_by, updated_by automatically
 * - Added nullable = false on all required columns
 * - Added length constraints to VARCHAR columns
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "company_id")
    private UUID companyId;

    @Column(name = "store_id")
    private UUID storeId;

    @Column(name = "user_role_id", nullable = false)
    private UUID userRoleId;

    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;

    @Column(name = "user_lastname", nullable = false, length = 100)
    private String userLastname;

    @Column(name = "user_dni", nullable = false, unique = true, length = 20)
    private String userDni;

    @Column(name = "user_email", nullable = false, unique = true, length = 255)
    private String userEmail;

    @Column(name = "user_password", nullable = false, length = 255)
    private String userPassword;

    @Column(name = "user_phone", nullable = false, unique = true, length = 50)
    private String userPhone;

    @Column(name = "user_address", length = 255)
    private String userAddress;

    @Column(name = "user_status", nullable = false)
    private Boolean userStatus;
}
