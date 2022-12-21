package com.restservice.rest.security.service;

import com.restservice.rest.security.dto.CreateUserDTO;
import com.restservice.rest.security.entity.User;
import com.restservice.rest.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.AttributeException;
import javax.print.PrintException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User create(CreateUserDTO dto) throws PrintException {
        if(userRepository.existsByUsername(dto.getUsername()))
            throw new PrintException("username already exists");
        if(userRepository.existsByEmail(dto.getEmail()))
            throw new PrintException("email already exists");
    }
}
