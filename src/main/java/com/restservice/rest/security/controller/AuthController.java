package com.restservice.rest.security.controller;

import com.restservice.rest.security.dto.CreateUserDTO;
import com.restservice.rest.security.dto.MessageDto;
import com.restservice.rest.security.entity.User;
import com.restservice.rest.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.PrintException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<MessageDto> create(@Valid @RequestBody CreateUserDTO dto) throws PrintException {
        User user = userService.create(dto);
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, "user " + user.getUsername() + " have been created"));
    }
}
