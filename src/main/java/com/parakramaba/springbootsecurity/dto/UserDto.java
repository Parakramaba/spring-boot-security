package com.parakramaba.springbootsecurity.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

    private String userName;
    private String password;
    private List<Integer> roleIds;
}
