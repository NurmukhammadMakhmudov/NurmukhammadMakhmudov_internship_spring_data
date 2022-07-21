package com.example.nurmukhammad_internship_spring_data.services;


import com.example.nurmukhammad_internship_spring_data.models.employees;
import com.example.nurmukhammad_internship_spring_data.models.interns;
import com.example.nurmukhammad_internship_spring_data.repos.InternsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternsServices {
    private final InternsRepository internsRepository;

    public InternsServices(InternsRepository internsRepository) {
        this.internsRepository = internsRepository;
    }
    public List<interns> getAllRecords(){
        return internsRepository.findAll();
    }
    public interns setIntern(interns intern){
        return internsRepository.save(intern);
    }
    public interns updateIntern(interns intern){
        internsRepository.findById(intern.getId()).orElseThrow(()-> new RuntimeException("User not Found"));
        return internsRepository.save(intern);
    }
    public interns findById(Long id){
        return internsRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
    }
    public void deleteById(Long id) {
        internsRepository.deleteById(id);
        internsRepository.findById(id).orElseThrow(() -> new RuntimeException("User deleted"));
    }

}
