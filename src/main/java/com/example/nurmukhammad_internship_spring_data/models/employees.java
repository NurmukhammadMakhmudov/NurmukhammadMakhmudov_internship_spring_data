package com.example.nurmukhammad_internship_spring_data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String first_name, last_name, position;
    public employees(){}
    public employees( String first_name, String last_name, String position){
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
    }
    public employees( Long id, String first_name, String last_name, String position){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
