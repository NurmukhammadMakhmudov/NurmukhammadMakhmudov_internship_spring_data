package com.example.nurmukhammad_internship_spring_data.controllers;

import com.example.nurmukhammad_internship_spring_data.services.EmployeesServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/employeelist")
public class employeesController {

    private final EmployeesServices employeesServices;


    public employeesController(EmployeesServices employeesServices) {
        this.employeesServices = employeesServices;
    }


    @GetMapping("")
    public String employees(Model model){
        model.addAttribute("employeeServices",employeesServices.getAllRecords());
        return "employees";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        model.addAttribute("byID", employeesServices.findById(id));
        return "byID";
    }


//    @GetMapping("")
//    public ResponseEntity<List<employees>> getAllRecords(){
//        List<employees> allRecords = employeesServices.getAllRecords();
//        return new ResponseEntity<>(allRecords, HttpStatus.OK);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<employees> getById(@PathVariable("id") Long id){
//        employees empl = employeesServices.findById(id);
//        return new ResponseEntity<>(empl, HttpStatus.OK);
//    }
//    @PostMapping("/add")
//    public ResponseEntity<employees> addEmployee(@RequestBody employees empl){
//        employees newEmployee = employeesServices.setEmployee(empl);
//        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
//    }
//    @PutMapping("/update")
//    public  ResponseEntity<employees> updateEmployee(@RequestBody employees empl){
//        employees updatedEmployee = employeesServices.updateEmployee(empl);
//        return  new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
//    }
//    @DeleteMapping("/delete")
//    public ResponseEntity<?> deleteEmployeeById(@RequestBody Long id){
//        employeesServices.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
