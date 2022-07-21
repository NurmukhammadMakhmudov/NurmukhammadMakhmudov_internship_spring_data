package com.example.nurmukhammad_internship_spring_data.controllers;
import com.example.nurmukhammad_internship_spring_data.models.interns;
import com.example.nurmukhammad_internship_spring_data.services.InternsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/interlist")
public class internsController {
    private final InternsServices internsServices;

    public internsController(InternsServices internsServices) {
        this.internsServices = internsServices;
    }


    @GetMapping("")
    public ResponseEntity<List<interns>> getAllRecords(){
        List<interns> intern = internsServices.getAllRecords();
        return new ResponseEntity<>(intern, HttpStatus.OK);
    }
    @GetMapping("/add")
    public ResponseEntity<interns> setIntern(interns intern){
        interns newIntern = internsServices.setIntern(intern);
        return new ResponseEntity<>(newIntern,HttpStatus.CREATED);
    }
    @GetMapping("/update")
    public ResponseEntity<interns> updateIntern(interns intern){
        interns updatingIntern = internsServices.updateIntern(intern);
        return new ResponseEntity<>(updatingIntern, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<interns> findById(Long id){
        interns intern = internsServices.findById(id);
        return new ResponseEntity<>(intern, HttpStatus.OK);
    }
    @GetMapping("/delete")
    public ResponseEntity<?> deleteById(Long id){
        internsServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
