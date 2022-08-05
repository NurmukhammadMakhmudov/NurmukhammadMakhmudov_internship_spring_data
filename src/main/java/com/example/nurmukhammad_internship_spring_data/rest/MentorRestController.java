package com.example.nurmukhammad_internship_spring_data.rest;

import com.example.nurmukhammad_internship_spring_data.models.Intern;
import com.example.nurmukhammad_internship_spring_data.services.InternsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MentorRestController {

    private final InternsServices internsServices;

    public MentorRestController(InternsServices internsServices) {
        this.internsServices = internsServices;
    }

    @PostMapping("/mentors")
    public ResponseEntity<List<Intern>> getAllRecords(Model model) {
        internsServices.getAllRecords().forEach((e) -> {
            if (e.getHobby() == null)
                e.setHobby("No Hobby Mentioned");
        });
        List<Intern> interns = internsServices.getAllRecords();
        return ResponseEntity.ok().body(interns);
    }


    @GetMapping("mentor/{id}")
    public void deleteIntern(@PathVariable("id") Long id) {
        internsServices.deleteById(id);

    }
}
