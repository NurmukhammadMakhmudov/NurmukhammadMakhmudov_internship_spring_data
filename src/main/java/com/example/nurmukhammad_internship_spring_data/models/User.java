package com.example.nurmukhammad_internship_spring_data.models;


import lombok.Data;


import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private byte role_id;
    private String first_name, last_name, email, pass_word;
    private Boolean isactive;
}
