package com.intern.demoproject.dto.mapper;

import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserMapper implements Function<User, UserDto> {


    @Override
    public UserDto apply(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getFullname(),
                user.getEmail()
        );
    }
}
