package com.restservice.rest.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CreateUserDTO {
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "email is required")
    @Email(message = "email not valid")
    private String email;
    @NotBlank(message = "password is required")
    private String password;

    List<String> roles;

    public CreateUserDTO() {
    }
    public CreateUserDTO(String username, String email, String password, List<String> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
