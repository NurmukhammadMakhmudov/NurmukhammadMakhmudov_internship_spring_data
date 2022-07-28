package com.example.nurmukhammad_internship_spring_data.services;


import com.example.nurmukhammad_internship_spring_data.models.Employees;
import com.example.nurmukhammad_internship_spring_data.repos.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServices {

    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesServices(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> getAllRecords() {
        return employeesRepository.findAll();
    }

    public void setEmployee(Employees empl) {
        employeesRepository.save(empl);
    }

    public Employees updateEmployee(Employees empl) {
        employeesRepository.findById(empl.getId()).orElseThrow(() -> new RuntimeException("User not Found"));
        return employeesRepository.save(empl);
    }

    public Employees findById(Long id) {
        return employeesRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
    }

    public void deleteById(Long id) {
        employeesRepository.deleteById(id);
    }

}
