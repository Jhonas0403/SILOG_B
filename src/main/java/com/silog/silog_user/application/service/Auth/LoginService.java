package com.silog.silog_user.application.service.Auth;

import com.silog.silog_user.domain.exception.InvalidCredentialsException;
import com.silog.silog_user.domain.exception.UserDisabledException;
import com.silog.silog_user.domain.model.AuthToken;
import com.silog.silog_user.domain.model.Role;
import com.silog.silog_user.domain.model.User;
import com.silog.silog_user.domain.port.in.Auth.LoginUseCase;
import com.silog.silog_user.domain.port.out.RoleRepositoryPort;
import com.silog.silog_user.domain.port.out.UserRepositoryPort;
import com.silog.silog_user.infrastructure.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final RoleRepositoryPort roleRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginService(UserRepositoryPort userRepositoryPort,
                        RoleRepositoryPort roleRepositoryPort,
                        PasswordEncoder passwordEncoder,
                        JwtService jwtService) {
        this.userRepositoryPort = userRepositoryPort;
        this.roleRepositoryPort = roleRepositoryPort;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthToken login(String email, String password) {
        User user = userRepositoryPort.findByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Email o contraseña incorrectos");
        }

        if (Boolean.FALSE.equals(user.getStatus())) {
            throw new UserDisabledException("La cuenta de usuario está deshabilitada");
        }

        String roleName = roleRepositoryPort.findById(user.getUserRoleId())
                .map(Role::getName)
                .orElse("UNKNOWN");

        String token = jwtService.generateToken(user, roleName);

        AuthToken authToken = new AuthToken();
        authToken.setToken(token);
        authToken.setUserId(user.getId());
        authToken.setEmail(user.getEmail());
        authToken.setFirstName(user.getFirstName());
        authToken.setLastName(user.getLastName());
        authToken.setCompanyId(user.getCompanyId());
        authToken.setStoreId(user.getStoreId());
        authToken.setUserRoleId(user.getUserRoleId());
        authToken.setRoleName(roleName);
        return authToken;
    }
}
