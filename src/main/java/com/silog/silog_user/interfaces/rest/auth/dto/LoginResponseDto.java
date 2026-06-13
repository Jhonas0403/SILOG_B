package com.silog.silog_user.interfaces.rest.auth.dto;

import com.silog.silog_user.domain.model.AuthToken;

import java.util.UUID;

public class LoginResponseDto {

    private String token;
    private UUID userId;
    private String email;
    private String firstName;
    private String lastName;
    private UUID companyId;
    private UUID storeId;
    private UUID userRoleId;
    private String roleName;

    public LoginResponseDto() {}

    public static LoginResponseDto fromDomain(AuthToken authToken) {
        LoginResponseDto dto = new LoginResponseDto();
        dto.token = authToken.getToken();
        dto.userId = authToken.getUserId();
        dto.email = authToken.getEmail();
        dto.firstName = authToken.getFirstName();
        dto.lastName = authToken.getLastName();
        dto.companyId = authToken.getCompanyId();
        dto.storeId = authToken.getStoreId();
        dto.userRoleId = authToken.getUserRoleId();
        dto.roleName = authToken.getRoleName();
        return dto;
    }

    public String getToken() { return token; }
    public UUID getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public UUID getCompanyId() { return companyId; }
    public UUID getStoreId() { return storeId; }
    public UUID getUserRoleId() { return userRoleId; }
    public String getRoleName() { return roleName; }
}
