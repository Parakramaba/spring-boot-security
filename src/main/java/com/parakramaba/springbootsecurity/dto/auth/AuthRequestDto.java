package com.parakramaba.springbootsecurity.dto.auth;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthRequestDto {

    private String userName;
    private String password;
}
