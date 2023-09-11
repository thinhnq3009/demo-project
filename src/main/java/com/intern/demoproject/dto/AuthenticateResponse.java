package com.intern.demoproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticateResponse {
    private String username;

    private String fullname;

    private String email;

    private String token;
}
