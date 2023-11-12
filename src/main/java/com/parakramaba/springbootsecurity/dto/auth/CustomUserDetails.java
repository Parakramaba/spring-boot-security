package com.parakramaba.springbootsecurity.dto.auth;

import com.parakramaba.springbootsecurity.entity.User;
import com.parakramaba.springbootsecurity.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean isActive;
    // FIXME: Will be needed in future iterations
//    private List<SimpleGrantedAuthority> authorities;
    private Role role;

    public CustomUserDetails(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.isActive = user.getIsActive();
//        this.authorities = user.getRoles().stream()
//                .map(Role::getName)
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
        this.role = user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
