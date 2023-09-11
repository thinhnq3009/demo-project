package com.intern.demoproject.dto.mapper;

import com.intern.demoproject.dto.AuthenticateResponse;
import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AuthenticateMapper implements Function<User, AuthenticateResponse> {


    @Override
    public AuthenticateResponse apply(User user) {
        return AuthenticateResponse
                .builder()
                .fullname(user.getFullname())
                .username(user.getUsername())
                .email(user.getEmail())
                .token("This is a token")
                .build();
    }
}
