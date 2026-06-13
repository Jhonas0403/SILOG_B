package com.silog.silog_user.domain.model;

import java.util.UUID;

public class AuthToken {
    private String token;
    private UUID userId;
    private String email;
    private String firstName;
    private String lastName;
    private UUID companyId;
    private UUID storeId;
    private UUID userRoleId;
    private String roleName;

    public AuthToken() {}

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public UUID getCompanyId() { return companyId; }
    public void setCompanyId(UUID companyId) { this.companyId = companyId; }

    public UUID getStoreId() { return storeId; }
    public void setStoreId(UUID storeId) { this.storeId = storeId; }

    public UUID getUserRoleId() { return userRoleId; }
    public void setUserRoleId(UUID userRoleId) { this.userRoleId = userRoleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
}
