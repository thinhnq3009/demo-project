package com.intern.demoproject.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterRequest {

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private String fullname;


}
