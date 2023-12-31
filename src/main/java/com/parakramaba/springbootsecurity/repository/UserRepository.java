package com.parakramaba.springbootsecurity.repository;

import com.parakramaba.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserNameAndIsActiveTrue(String userName);

    Boolean existsByUserName(String userName);
}
