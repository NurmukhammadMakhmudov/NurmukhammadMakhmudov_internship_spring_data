package com.example.nurmukhammad_internship_spring_data.repos;

import com.example.nurmukhammad_internship_spring_data.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
