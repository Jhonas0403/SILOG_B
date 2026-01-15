package com.silog.silog_user.infrastructure.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "company_id")
    private UUID companyId;

    @Column(name = "store_id")
    private UUID storeId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_lastname", nullable = false)
    private String userLastname;

    @Column(name = "user_dni", nullable = false, unique = true)
    private String userDni;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_phone", nullable = false, unique = true)
    private String userPhone;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_role_id", nullable = false)
    private UUID userRoleId;

    @Column(name = "user_status", nullable = false)
    private Boolean userStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public UserEntity() {}

    // getters y setters (genera desde tu IDE)
    public UUID getUserId() { return id; }
    public void setUserId(UUID id) { this.id = id; }

    public UUID getCompanyId() { return companyId; }
    public void setCompanyId(UUID companyId) { this.companyId = companyId; }

    public UUID getStoreId() { return storeId; }
    public void setStoreId(UUID storeId) { this.storeId = storeId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserLastname() { return userLastname; }
    public void setUserLastname(String userLastname) { this.userLastname = userLastname; }

    public String getUserDni() { return userDni; }
    public void setUserDni(String userDni) { this.userDni = userDni; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public String getUserPhone() { return userPhone; }
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }

    public String getUserAddress() { return userAddress; }
    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    public UUID getUserRoleId() { return userRoleId; }
    public void setUserRoleId(UUID userRoleId) { this.userRoleId = userRoleId; }

    public Boolean getUserStatus() { return userStatus; }
    public void setUserStatus(Boolean userStatus) { this.userStatus = userStatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
