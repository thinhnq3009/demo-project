package com.intern.demoproject.service;

import com.intern.demoproject.dto.AuthenticateResponse;
import com.intern.demoproject.dto.mapper.AuthenticateMapper;
import com.intern.demoproject.dto.mapper.UserMapper;
import com.intern.demoproject.entity.User;
import com.intern.demoproject.repository.UserRepository;
import com.intern.demoproject.request.AuthenticateRequest;
import com.intern.demoproject.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticateService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final AuthenticateMapper authenticateMapper;

    public AuthenticateResponse login(AuthenticateRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User userDetails = userRepository.findByUsername(request.getUsername())
                .orElseThrow();

        return authenticateMapper.apply(userDetails);


    }


    public AuthenticateResponse register(RegisterRequest request) {

        Optional<User> userOtn = userRepository.findByUsername(request.getUsername());

        if (userOtn.isPresent()) {
            throw new RuntimeException("User already exists");
        }


        User user = User
                .builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .fullname(request.getFullname())
                .password(
                        passwordEncoder.encode(request.getPassword())
                )
                .build();

        userRepository.save(user);

        return authenticateMapper.apply(user);



    }
}
