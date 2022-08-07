package com.example.nurmukhammad_internship_spring_data.rest;

import com.example.nurmukhammad_internship_spring_data.models.Employees;
import com.example.nurmukhammad_internship_spring_data.services.EmployeesServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeesServices employeesServices;

    public EmployeeRestController(EmployeesServices employeesServices) {
        this.employeesServices = employeesServices;
    }

    @PostMapping("employees")
    public ResponseEntity<List<Employees>> employees() {
        return ResponseEntity.ok().body( employeesServices.getAllRecords());
    }

    @GetMapping("employees/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        employeesServices.deleteById(id);

    }
}
