package com.parakramaba.springbootsecurity.controller;

import com.parakramaba.springbootsecurity.dto.UserDto;
import com.parakramaba.springbootsecurity.dto.auth.AuthRequestDto;
import com.parakramaba.springbootsecurity.dto.auth.AuthResponseDto;
import com.parakramaba.springbootsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(final @RequestBody UserDto userDto) {
        return authenticationService.registerUser(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> loginUser(final @RequestBody AuthRequestDto authRequestDto) {
        return authenticationService.loginUser(authRequestDto);
    }
}
