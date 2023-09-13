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

    private final UserMapper userMapper;

    @Override
    public AuthenticateResponse apply(User user) {
        UserDto userDto = userMapper.apply(user);
        return new AuthenticateResponse(userDto)
                .token(
                        jwtService.generateToken(user)
                );
    }


}
