package com.example.nurmukhammad_internship_spring_data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class NurmukhammadInternshipSpringDataApplication implements CommandLineRunner
{

    public static void main(String[] args) {

        SpringApplication.run(NurmukhammadInternshipSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
