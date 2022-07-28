package com.example.nurmukhammad_internship_spring_data.services;


import com.example.nurmukhammad_internship_spring_data.models.Intern;
import com.example.nurmukhammad_internship_spring_data.repos.InternsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternsServices {
    private final InternsRepository internsRepository;

    @Autowired
    public InternsServices(InternsRepository internsRepository) {
        this.internsRepository = internsRepository;
    }

    public List<Intern> getAllRecords() {
        return internsRepository.findAll();
    }

    public void setIntern(Intern intern) {
        internsRepository.save(intern);
    }

    public Intern updateIntern(Intern intern) {
        internsRepository.findById(intern.getId()).orElseThrow(() -> new RuntimeException("User not Found"));
        return internsRepository.save(intern);
    }

    public Intern findById(Long id) {
        return internsRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
    }

    public void deleteById(Long id) {
        internsRepository.deleteById(id);
    }

}
