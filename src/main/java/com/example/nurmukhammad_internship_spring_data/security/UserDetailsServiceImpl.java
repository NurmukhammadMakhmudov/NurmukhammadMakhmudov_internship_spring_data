package com.example.nurmukhammad_internship_spring_data.security;

import com.example.nurmukhammad_internship_spring_data.models.User;
import com.example.nurmukhammad_internship_spring_data.repos.UserRepository;
import com.example.nurmukhammad_internship_spring_data.services.RoleServices;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleServices roleServices;

    public UserDetailsServiceImpl(UserRepository userRepository, RoleServices roleServices) {
        this.userRepository = userRepository;
        this.roleServices = roleServices;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
        return SecurityUser.formUser(user, roleServices);
    }
}
