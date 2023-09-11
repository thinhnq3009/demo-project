package com.intern.demoproject.service;

import com.intern.demoproject.dto.AuthenticateResponse;
import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.dto.mapper.AuthenticateMapper;
import com.intern.demoproject.dto.mapper.UserMapper;
import com.intern.demoproject.entity.User;
import com.intern.demoproject.repository.UserRepository;
import com.intern.demoproject.request.AuthenticateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserDto> findUser(String username) {

        List<User> users =  userRepository.findAllByUsername(username);

        return users
                .stream()
                .map(userMapper)
                .collect(Collectors.toList());

    }

    public Page<UserDto> findUser(int page, int size) {

        return userRepository
                .findAll(Pageable.ofSize(size).withPage(page))
                .map(userMapper);

    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserDto findUserById(Long id) {

        return userRepository
                .findById(id)
                .map(userMapper)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );

    }

    public UserDto updateUser(Long id, UserDto userDto) {

            User user = userRepository
                    .findById(id)
                    .orElseThrow(
                            () -> new UsernameNotFoundException("User not found")
                    );


            if (userDto.getFullname() != null)
                user.setFullname(userDto.getFullname());

            if (userDto.getEmail() != null)
                user.setEmail(userDto.getEmail());



            userRepository.save(user);

            return userMapper.apply(user);
    }
}
