package com.example.nurmukhammad_internship_spring_data.rest;


import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    private String username;
    private String password;
}
