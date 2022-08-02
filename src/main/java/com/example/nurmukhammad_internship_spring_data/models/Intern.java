package com.example.nurmukhammad_internship_spring_data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interns")
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String first_name;
    private String last_name;
    private String hobby;
    private LocalDate date_of_birth;

}
