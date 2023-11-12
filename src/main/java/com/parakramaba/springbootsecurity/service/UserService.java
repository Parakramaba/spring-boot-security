package com.parakramaba.springbootsecurity.service;

import com.parakramaba.springbootsecurity.entity.User;
import com.parakramaba.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service("UserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @return
     */
    public ResponseEntity<?> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
