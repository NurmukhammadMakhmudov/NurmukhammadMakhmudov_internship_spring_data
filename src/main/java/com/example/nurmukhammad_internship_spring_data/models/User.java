package com.example.nurmukhammad_internship_spring_data.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private byte role_id;
    private String first_name;
    private String last_name;
    private String email;
    private String pass_word;
    private Boolean isactive;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", updatable = false, insertable = false)

    private Role roles;
}

