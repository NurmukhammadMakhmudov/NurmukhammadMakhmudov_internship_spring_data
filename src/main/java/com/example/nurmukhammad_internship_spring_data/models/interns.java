package com.example.nurmukhammad_internship_spring_data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class interns {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String first_name, last_name, hobby;
    LocalDate date_of_birth;

    public interns(){}

    public interns(String first_name, String last_name, String hobby, LocalDate date_of_birth){
        this.first_name = first_name;
        this.last_name = last_name;
        this.hobby = hobby;
        this.date_of_birth = date_of_birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
