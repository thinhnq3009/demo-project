package com.intern.demoproject.controller;

import com.intern.demoproject.dto.AuthenticateResponse;
import com.intern.demoproject.dto.commom.CustomResponseEntity;
import com.intern.demoproject.dto.commom.ResponseHandler;
import com.intern.demoproject.request.AuthenticateRequest;
import com.intern.demoproject.request.RegisterRequest;
import com.intern.demoproject.service.AuthenticateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.intern.demoproject.utils.Constants.AuthPaths.AUTH_PATH;

@Controller
@RequestMapping(AUTH_PATH)
@RequiredArgsConstructor
@Tag(name = "AuthenticationController", description = "Authentication controller")
public class AuthenticationController {

    private final AuthenticateService   authService;

    @PostMapping("/login")
    @Operation(summary = "login", description = "Đăng nhập")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = AuthenticateResponse.class),
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            schema = @Schema(implementation = Map.class),
                            mediaType = "application/json"
                    )
            )

    })
    public CustomResponseEntity<AuthenticateResponse> login(
            @RequestBody AuthenticateRequest request
    ) {

        AuthenticateResponse response = authService.login(request);

        return CustomResponseEntity
                .of(response, HttpStatus.OK)
                .result(true);
    }

    @Operation(summary = "register", description = "Đăng ký")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = AuthenticateResponse.class),
                            mediaType = "application/json"
                    )
            )
    })

    @PostMapping("/register")
    public CustomResponseEntity<AuthenticateResponse> register(
            @RequestBody RegisterRequest request
    ) {
        AuthenticateResponse response = authService.register(request);


        return CustomResponseEntity
                .of(response, HttpStatus.OK)
                .result(true);
    }
}
