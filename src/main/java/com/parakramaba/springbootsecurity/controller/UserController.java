package com.parakramaba.springbootsecurity.controller;

import com.parakramaba.springbootsecurity.dto.UserDto;
import com.parakramaba.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<?> createUser(final @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }
}
