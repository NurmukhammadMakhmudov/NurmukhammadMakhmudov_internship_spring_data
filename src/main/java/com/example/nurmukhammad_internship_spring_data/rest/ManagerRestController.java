package com.example.nurmukhammad_internship_spring_data.rest;

import com.example.nurmukhammad_internship_spring_data.models.Employees;
import com.example.nurmukhammad_internship_spring_data.services.EmployeesServices;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ManagerRestController {

    private final EmployeesServices employeesServices;

    public ManagerRestController(EmployeesServices employeesServices) {
        this.employeesServices = employeesServices;
    }

    @PostMapping("managers")
    public ResponseEntity<List<Employees>> employees(Model model) {


        return ResponseEntity.ok().body( employeesServices.getAllRecords());
    }

    @GetMapping("managers/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        employeesServices.deleteById(id);

    }
}
