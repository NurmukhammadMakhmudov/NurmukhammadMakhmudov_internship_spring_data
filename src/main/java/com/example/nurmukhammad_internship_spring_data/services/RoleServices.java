package com.example.nurmukhammad_internship_spring_data.services;

import com.example.nurmukhammad_internship_spring_data.repos.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServices {
    private final RoleRepository roleRepository;

    public RoleServices(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public String getRoleName(int roleIndex) {
        return roleRepository.findAll().get(roleIndex).getName();
    }
    public String getRole(int roleIndex){
        return roleRepository.findAll().get(roleIndex).getRole();
    }
}
