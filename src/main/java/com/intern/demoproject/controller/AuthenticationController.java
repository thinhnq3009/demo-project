package com.intern.demoproject.controller;

import com.intern.demoproject.dto.AuthenticateResponse;
import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.dto.commom.ResponseHandler;
import com.intern.demoproject.request.AuthenticateRequest;
import com.intern.demoproject.request.RegisterRequest;
import com.intern.demoproject.service.AuthenticateService;
import com.intern.demoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticateService   authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody AuthenticateRequest request
    ) {

        AuthenticateResponse response = authService.login(request);

        return ResponseHandler.response(response, HttpStatus.OK, false);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ) {
        AuthenticateResponse response = authService.register(request);

        return ResponseHandler.response(response, HttpStatus.OK, true);
    }
}
