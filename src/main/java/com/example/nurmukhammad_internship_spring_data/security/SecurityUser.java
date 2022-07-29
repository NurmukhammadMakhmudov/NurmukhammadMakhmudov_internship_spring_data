package com.example.nurmukhammad_internship_spring_data.security;


import com.example.nurmukhammad_internship_spring_data.models.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;


@Data
public class SecurityUser implements UserDetails {

    public SecurityUser(String username, String password, boolean isActive) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }
    private final String username;
    private final String password;
    private final boolean isActive;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
    public static UserDetails formUser(User user){
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPass_word(),
                user.getIsactive(),
                user.getIsactive(),
                user.getIsactive(),
                user.getIsactive(),
                Arrays.asList(new SimpleGrantedAuthority("ADMIN"))
        );
    }
}
