package com.example.nurmukhammad_internship_spring_data.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String first_name, last_name, position;

    public Employees() {
    }

    public Employees(String first_name, String last_name, String position) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
    }

    public Employees(Long id, String first_name, String last_name, String position) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
    }

}
