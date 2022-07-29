package com.example.nurmukhammad_internship_spring_data.security;

import com.example.nurmukhammad_internship_spring_data.models.User;
import com.example.nurmukhammad_internship_spring_data.repos.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User doesn't exist"));
        return SecurityUser.formUser(user);
    }
}
