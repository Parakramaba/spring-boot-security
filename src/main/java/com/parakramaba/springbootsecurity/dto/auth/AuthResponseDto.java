package com.parakramaba.springbootsecurity.dto.auth;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthResponseDto {

    private String token;
}
