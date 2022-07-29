package com.example.nurmukhammad_internship_spring_data.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class authController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/success")
    public String getIndexPage(){
        return "/success";
    }

}
