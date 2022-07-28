package com.example.nurmukhammad_internship_spring_data.controllers;

import com.example.nurmukhammad_internship_spring_data.models.Employees;
import com.example.nurmukhammad_internship_spring_data.models.Intern;
import com.example.nurmukhammad_internship_spring_data.services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/employeelist")
public class employeesController {

    private final EmployeesServices employeesServices;

    @Autowired
    public employeesController(EmployeesServices employeesServices) {
        this.employeesServices = employeesServices;
    }


    @GetMapping("")
    public String employees(Model model) {

        model.addAttribute("employeeServices", employeesServices.getAllRecords());
        return "employees";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("byID", employeesServices.findById(id));
        return "byID";
    }

    @GetMapping("/employee-create")
    public String createEmployeeForm(Employees employee, Model model) {
        model.addAttribute("employee", employee);
        return "employee-create";
    }

    @PostMapping("/employee-create")
    public String createEmployee(Employees employees) {
        employeesServices.setEmployee(employees);
        return "redirect:/employeelist";
    }

    @GetMapping("/employee-update/{id}")
    public String updateEmployeeForm(@PathVariable("id") Long id, Model model) {
        Employees employee = employeesServices.findById(id);
        model.addAttribute("employee", employee);
        return "employee-update";
    }

    @PostMapping("/employee-update")
    public String updateEmployee(Employees employees) {
        employeesServices.setEmployee(employees);
        return "redirect:/employeelist";
    }

    @GetMapping("employee-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        employeesServices.deleteById(id);
        return "redirect:/employeelist";
    }

}
