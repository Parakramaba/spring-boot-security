package com.parakramaba.springbootsecurity.service;

import com.parakramaba.springbootsecurity.dto.UserDto;
import com.parakramaba.springbootsecurity.entity.User;
import com.parakramaba.springbootsecurity.entity.auth.Role;
import com.parakramaba.springbootsecurity.exception.ErrorMessages;
import com.parakramaba.springbootsecurity.exception.ResourceNotFoundException;
import com.parakramaba.springbootsecurity.repository.UserRepository;
import com.parakramaba.springbootsecurity.repository.auth.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service("UserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    /**
     *
     * @param userDto
     * @return
     */
    public ResponseEntity<?> createUser(final UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        user.setRoles(setUserRoles(userDto.getRoleIds()));
        userRepository.save(user);

        return new ResponseEntity<>("User create successfully", HttpStatus.CREATED);
    }

    /**
     *
     * @return
     */
    public ResponseEntity<?> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    private List<Role> setUserRoles(final List<Integer> roleIds) {
        List<Role> userRoles = new ArrayList<>();
        
        // Add default role for user
        if (roleIds == null || roleIds.isEmpty()) {
            Role defaultRole = roleRepository.findById(1).orElseThrow(()
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
