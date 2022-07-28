package com.example.nurmukhammad_internship_spring_data.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String role, name;


    public role(long id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public role() {

    }
}
