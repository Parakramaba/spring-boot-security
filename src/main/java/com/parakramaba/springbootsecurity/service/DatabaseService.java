package com.parakramaba.springbootsecurity.service;

import com.parakramaba.springbootsecurity.entity.User;
import com.parakramaba.springbootsecurity.entity.auth.Role;
import com.parakramaba.springbootsecurity.repository.UserRepository;
import com.parakramaba.springbootsecurity.repository.auth.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DatabaseService")
public class DatabaseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void initDB() {
//        userRepository.saveAll(dbSetUsers());
    }

    // TODO: find a proper way to add initial data to the database
    private List<User> dbSetUsers() {

        User user1 = User.builder()
                .userName("user")
                .password(bCryptPasswordEncoder.encode("user-pw"))
                .isActive(true)
                .roles(List.of(dbSetRoles().get(0)))
                .build();
        User user2 = User.builder()
                .userName("admin")
                .password(bCryptPasswordEncoder.encode("admin-pw"))
                .isActive(true)
                .roles(List.of(dbSetRoles().get(1)))
                .build();
        return List.of(user1, user2);

    }

    private List<Role> dbSetRoles() {
        Role role1 = Role.builder()
                .name("ROLE_USER")
                .build();

        Role role2 = Role.builder()
                .name("ROLE_ADMIN")
                .build();

        return List.of(role1, role2);
    }
}
