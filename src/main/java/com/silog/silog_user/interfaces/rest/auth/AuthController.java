package com.silog.silog_user.interfaces.rest.auth;

import com.silog.silog_user.domain.model.AuthToken;
import com.silog.silog_user.domain.port.in.Auth.LoginUseCase;
import com.silog.silog_user.interfaces.rest.auth.dto.LoginRequestDto;
import com.silog.silog_user.interfaces.rest.auth.dto.LoginResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto request) {
        AuthToken authToken = loginUseCase.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(LoginResponseDto.fromDomain(authToken));
    }
}
