package com.example.nurmukhammad_internship_spring_data.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "interns")
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String first_name, last_name, hobby;
    LocalDate date_of_birth;

    public Intern() {
    }

    public Intern(String first_name, String last_name, String hobby, LocalDate date_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.hobby = hobby;
        this.date_of_birth = date_of_birth;
    }

}
