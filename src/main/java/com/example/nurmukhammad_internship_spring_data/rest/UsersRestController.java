package com.example.nurmukhammad_internship_spring_data.rest;

import com.example.nurmukhammad_internship_spring_data.models.User;
import com.example.nurmukhammad_internship_spring_data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class UsersRestController {

    private final UserService usersServices;

    @Autowired
    public UsersRestController(UserService usersServices) {
        this.usersServices = usersServices;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllRecords() {
        List<User> users = usersServices.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/users/admin")
    public ResponseEntity<List<User>> getAllAdmins() {
        List<User> Admins = usersServices.findAll().stream().filter(e -> e.getRoles().getRole().equals("ADMIN")).collect(Collectors.toList());
        return ResponseEntity.ok().body(Admins);
    }

    @GetMapping("/users/mentor")
    public ResponseEntity<List<User>> getAllMentors() {
        List<User> Mentors = usersServices.findAll().stream().filter(e -> e.getRoles().getRole().equals("MENTOR")).collect(Collectors.toList());
        return ResponseEntity.ok().body(Mentors);
    }

    @GetMapping("/users/manager")
    public ResponseEntity<List<User>> getAllManagers() {
        List<User> Managers = usersServices.findAll().stream().filter(e -> e.getRoles().getRole().equals("MANAGERS")).collect(Collectors.toList());
        return ResponseEntity.ok().body(Managers);
    }


    @PostMapping("users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        usersServices.deleteById(id);
    }


}
