package com.example.nurmukhammad_internship_spring_data.rest;

import com.example.nurmukhammad_internship_spring_data.models.Intern;
import com.example.nurmukhammad_internship_spring_data.services.InternsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class InternsRestController {

    private final InternsServices internsServices;

    public InternsRestController(InternsServices internsServices) {
        this.internsServices = internsServices;
    }

    @PostMapping("/interns")
    public ResponseEntity<List<Intern>> getAllRecords() {
        List<Intern> interns = internsServices.getAllRecords();
        return ResponseEntity.ok().body(interns);
    }


    @GetMapping("interns/{id}")
    public void deleteIntern(@PathVariable("id") Long id) {
        internsServices.deleteById(id);

    }
}
