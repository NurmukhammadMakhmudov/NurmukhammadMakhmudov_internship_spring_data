package com.example.nurmukhammad_internship_spring_data.security;


import com.example.nurmukhammad_internship_spring_data.models.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
public class SecurityUser implements UserDetails {

    public SecurityUser(String username, String password, boolean isActive, List<SimpleGrantedAuthority> authorities) {
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
    public static UserDetails formUser(User user){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        if (user.getRole_id() == 1) {
            list.add(new SimpleGrantedAuthority("ADMIN"));
        }
        else if (user.getRole_id() == 2){
            list.add(new SimpleGrantedAuthority("MANAGER"));

        }
        else if (user.getRole_id() ==3) {
            list.add(new SimpleGrantedAuthority("MENTOR"));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPass_word(),
                user.getIsactive(),
                user.getIsactive(),
                user.getIsactive(),
                user.getIsactive(),
                list

                );

    }
}
