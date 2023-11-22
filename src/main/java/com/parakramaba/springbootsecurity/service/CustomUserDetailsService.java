package com.parakramaba.springbootsecurity.service;

import com.parakramaba.springbootsecurity.dto.auth.CustomUserDetails;
import com.parakramaba.springbootsecurity.entity.User;
import com.parakramaba.springbootsecurity.exception.ErrorMessages;
import com.parakramaba.springbootsecurity.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 */
@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserNameAndIsActiveTrue(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(ErrorMessages.USER_NOT_FOUND_MSG + userName));
        return user.map(CustomUserDetails::new).get();
    }
}
