package com.intern.demoproject.dto.mapper;

import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserMapper implements Function<User, UserDto> {


    @Override
    public UserDto apply(User user) {
        return UserDto
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .role(user.getRole().name())
                .fullname(user.getFullname())
                .username(user.getUsername())
                .build();
    }
}
