package com.parakramaba.springbootsecurity.service;

import com.parakramaba.springbootsecurity.dto.UserDto;
import com.parakramaba.springbootsecurity.entity.User;
import com.parakramaba.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("UserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param userDto
     * @return
     */
    public ResponseEntity<?> createUser(final UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        if (userDto.getRoles() != null && userDto.getRoles().length() > 0) {
            user.setRoles(userDto.getRoles());
        } else {
            user.setRoles("ROLE_USER");
        }

        userRepository.save(user);

        return new ResponseEntity<>("User create successfully", HttpStatus.CREATED);
    }
}
