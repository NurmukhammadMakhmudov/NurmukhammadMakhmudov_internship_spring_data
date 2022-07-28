package com.example.nurmukhammad_internship_spring_data.controllers;


import com.example.nurmukhammad_internship_spring_data.models.User;
import com.example.nurmukhammad_internship_spring_data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userlist")
public class usersController {
    private final UserService usersServices;

    @Autowired
    public usersController(UserService usersServices) {
        this.usersServices = usersServices;
    }

    @GetMapping
    public String getAllRecords(Model model) {
        List<User> users = usersServices.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        usersServices.saveUser(user);
        return "redirect:/userlist";
    }


    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersServices.deleteById(id);
        return "redirect:/userlist";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = usersServices.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        usersServices.saveUser(user);
        return "redirect:/userlist";
    }
}
