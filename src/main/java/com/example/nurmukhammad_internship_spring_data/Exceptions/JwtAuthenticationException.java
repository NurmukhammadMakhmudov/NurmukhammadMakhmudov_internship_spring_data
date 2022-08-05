package com.example.nurmukhammad_internship_spring_data.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.naming.AuthenticationException;

@Getter
public class JwtAuthenticationException extends AuthenticationException {

    private final HttpStatus httpStatus;

    public JwtAuthenticationException(String explanation, HttpStatus httpStatus) {
        super(explanation);
        this.httpStatus = httpStatus;
    }

}
