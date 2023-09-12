package com.intern.demoproject.dto.mapper;

import com.intern.demoproject.dto.AuthenticateResponse;
import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.entity.User;
import com.intern.demoproject.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class AuthenticateMapper implements Function<User, AuthenticateResponse> {

    private final JwtService jwtService;

    @Override
    public AuthenticateResponse apply(User user) {
        return AuthenticateResponse
                .builder()
                .fullname(user.getFullname())
                .username(user.getUsername())
                .email(user.getEmail())
                .token(jwtService.generateToken(user))
                .build();
    }
}
