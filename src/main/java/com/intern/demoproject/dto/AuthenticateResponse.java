package com.intern.demoproject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthenticateResponse extends UserDto {

    private String token;


    public AuthenticateResponse(UserDto userDto) {
        super(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getFullname(),
                userDto.getEmail(),
                userDto.getAvatar(),
                userDto.getRole());
    }

    public AuthenticateResponse token(String token) {
        setToken(token);
        return this;
    }
}
