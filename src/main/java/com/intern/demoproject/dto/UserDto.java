package com.intern.demoproject.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String fullname;

    private String email;

    private String avatar;

    private String role;

}
