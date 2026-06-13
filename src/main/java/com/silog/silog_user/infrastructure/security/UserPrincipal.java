package com.silog.silog_user.infrastructure.security;

public class UserPrincipal {

    private final String userId;
    private final String storeId;
    private final String companyId;
    private final String roleName;

    public UserPrincipal(String userId, String storeId, String companyId, String roleName) {
        this.userId = userId;
        this.storeId = storeId;
        this.companyId = companyId;
        this.roleName = roleName;
    }

    public String getUserId() { return userId; }
    public String getStoreId() { return storeId; }
    public String getCompanyId() { return companyId; }
    public String getRoleName() { return roleName; }

    @Override
    public String toString() { return userId; }
}
