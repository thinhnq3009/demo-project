package com.intern.demoproject.request;

import lombok.Data;

@Data
public class AuthenticateRequest {

    private String username;

    private String password;

}
