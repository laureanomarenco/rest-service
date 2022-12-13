package com.restservice.rest.security.dto;

import java.util.List;

public class CreateUserDTO {
    @NotBlank
    private String username;
    private String email;
    private String password;
    List<String> roles;

    public CreateUserDTO() {
    }
}
