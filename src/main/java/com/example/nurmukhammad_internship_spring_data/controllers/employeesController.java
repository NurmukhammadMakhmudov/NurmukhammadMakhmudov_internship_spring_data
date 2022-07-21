package com.example.nurmukhammad_internship_spring_data.controllers;

import com.example.nurmukhammad_internship_spring_data.models.employees;
import com.example.nurmukhammad_internship_spring_data.repos.EmployeesRepository;
import com.example.nurmukhammad_internship_spring_data.services.EmployeesServices;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employeelist")
public class employeesController {

    private final EmployeesServices employeesServices;


    public employeesController(EmployeesServices employeesServices) {
        this.employeesServices = employeesServices;
    }

    @GetMapping("")
    public ResponseEntity<List<employees>> getAllRecords(){
        List<employees> allRecords = employeesServices.getAllRecords();
        return new ResponseEntity<>(allRecords, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<employees> getById(@PathVariable("id") Long id){
        employees empl = employeesServices.findById(id);
        return new ResponseEntity<>(empl, HttpStatus.OK);
    }
    @GetMapping("/add")
    public ResponseEntity<employees> addEmployee(@RequestBody employees empl){
        employees newEmployee = employeesServices.setEmployee(empl);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @GetMapping("/update")
    public  ResponseEntity<employees> updateEmployee(@RequestBody employees empl){
        employees updatedEmployee = employeesServices.updateEmployee(empl);
        return  new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
    }
    @GetMapping("/delete")
    public ResponseEntity<?> deleteEmployeeById(@RequestBody Long id){
        employeesServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
