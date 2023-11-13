package com.parakramaba.springbootsecurity.service;

import com.parakramaba.springbootsecurity.dto.UserDto;
import com.parakramaba.springbootsecurity.dto.auth.AuthRequestDto;
import com.parakramaba.springbootsecurity.dto.auth.AuthResponseDto;
import com.parakramaba.springbootsecurity.dto.auth.CustomUserDetails;
import com.parakramaba.springbootsecurity.entity.User;
import com.parakramaba.springbootsecurity.entity.auth.Role;
import com.parakramaba.springbootsecurity.exception.ErrorMessages;
import com.parakramaba.springbootsecurity.exception.ResourceNotFoundException;
import com.parakramaba.springbootsecurity.repository.UserRepository;
import com.parakramaba.springbootsecurity.repository.auth.RoleRepository;
import com.parakramaba.springbootsecurity.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AuthenticationService")
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtService jwtService;

    private static final Integer defaultRoleId = 1;

    /**
     *
     * @param userDto
     * @return
     */
    public ResponseEntity<AuthResponseDto> registerUser(final UserDto userDto) {
        User user = User.builder()
                .userName(userDto.getUserName())
                .password(bCryptPasswordEncoder.encode(userDto.getPassword()))
                .roles(setUserRoles(userDto.getRoleIds()))
                .isActive(Boolean.TRUE)
                .build();
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(new CustomUserDetails(user));
        AuthResponseDto response = AuthResponseDto.builder()
                .token(jwtToken)
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<AuthResponseDto> loginUser(final AuthRequestDto authRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getUserName(),
                        authRequestDto.getPassword()
                )
        );
        var user = userRepository.findByUserName(authRequestDto.getUserName())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(new CustomUserDetails(user));
        AuthResponseDto response = AuthResponseDto.builder()
                .token(jwtToken)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private List<Role> setUserRoles(final List<Integer> roleIds) {
        List<Role> userRoles = new ArrayList<>();

        // Add default role for user
        if (roleIds == null || roleIds.isEmpty()) {
            Role defaultRole = roleRepository.findById(defaultRoleId).orElseThrow(()
                    -> new ResourceNotFoundException(ErrorMessages.ROLE_NOT_FOUND_MSG));
            userRoles.add(defaultRole);
        }
        else {
            for (Integer roleId
                    : roleIds
            ) {
                Role role = roleRepository.findById(roleId).orElseThrow(()
                        -> new ResourceNotFoundException(ErrorMessages.ROLE_NOT_FOUND_MSG));
                userRoles.add(role);
            }
        }
        return userRoles;
    }
}
