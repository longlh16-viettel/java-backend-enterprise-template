package com.vtt.auth_service.service;

import com.vtt.auth_service.dto.request.LoginRequest;
import com.vtt.auth_service.dto.response.LoginResponse;
import com.vtt.auth_service.entity.User;
import com.vtt.auth_service.repository.UserRepository;
import com.vtt.auth_service.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow();

        String token = jwtProvider.generateToken(
                user.getUsername(),
                user.getRole()
        );

        return new LoginResponse(token);
    }
}
