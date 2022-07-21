package com.example.nurmukhammad_internship_spring_data.repos;

import com.example.nurmukhammad_internship_spring_data.models.employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<employees, Long> {
}
