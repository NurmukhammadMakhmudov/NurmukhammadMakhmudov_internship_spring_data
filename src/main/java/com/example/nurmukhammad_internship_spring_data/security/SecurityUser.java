package com.example.nurmukhammad_internship_spring_data.security;


import com.example.nurmukhammad_internship_spring_data.models.User;
import com.example.nurmukhammad_internship_spring_data.services.RoleServices;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;


@Data
public class SecurityUser implements UserDetails {

    public SecurityUser(String username, String password, boolean isActive, List<SimpleGrantedAuthority> authorities, RoleServices roleServices) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.authorities = authorities;
    }

    private final String username;
    private final String password;
    private final boolean isActive;
    private final List<SimpleGrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;

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

    protected static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    public static UserDetails formUser(User user, RoleServices roleServices) {


        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPass_word(),
                user.getIsactive(),
                user.getIsactive(),
                user.getIsactive(),
                user.getIsactive(),
                List.of(new SimpleGrantedAuthority(roleServices.getRole((user.getRole_id() - 1))))

        );

    }
}
