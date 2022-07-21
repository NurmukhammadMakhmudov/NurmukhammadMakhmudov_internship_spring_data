package com.example.nurmukhammad_internship_spring_data.services;


import com.example.nurmukhammad_internship_spring_data.models.employees;
import com.example.nurmukhammad_internship_spring_data.repos.EmployeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServices {

    private final EmployeesRepository employeesRepository;

    public EmployeesServices(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }
    public List<employees> getAllRecords(){
        return employeesRepository.findAll();
    }
    public employees setEmployee(employees empl){
        return employeesRepository.save(empl);
    }
    public employees updateEmployee(employees empl){
        employeesRepository.findById(empl.getId()).orElseThrow(()-> new RuntimeException("User not Found"));
        return employeesRepository.save(empl);
    }
    public employees findById(Long id){
        return employeesRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
    }

    public void deleteById(Long id) {
        employeesRepository.deleteById(id);
        employeesRepository.findById(id).orElseThrow(() -> new RuntimeException("User deleted"));
    }

}
