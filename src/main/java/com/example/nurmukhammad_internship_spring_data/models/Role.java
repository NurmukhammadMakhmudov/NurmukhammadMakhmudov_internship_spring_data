package com.example.nurmukhammad_internship_spring_data.models;


import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String role, name;

}
