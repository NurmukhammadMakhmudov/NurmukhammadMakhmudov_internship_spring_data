package com.example.nurmukhammad_internship_spring_data.controllers;

import com.example.nurmukhammad_internship_spring_data.models.Intern;
import com.example.nurmukhammad_internship_spring_data.services.InternsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interlist")
public class internsController {
    private final InternsServices internsServices;

    @Autowired
    public internsController(InternsServices internsServices) {
        this.internsServices = internsServices;
    }


    @GetMapping
    public String getAllRecords(Model model) {
        internsServices.getAllRecords().forEach((e) -> {
            if (e.getHobby() == null)
                e.setHobby("No Hobby Mentioned");
        });
        model.addAttribute("internsServices", internsServices.getAllRecords());
        return "interns";
    }


    @GetMapping("/intern-create")
    public String createInternForm(Intern intern, Model model) {

        return "intern-create";
    }

    @PostMapping("/intern-create")
    public String createIntern(Intern intern) {
        internsServices.setIntern(intern);
        return "redirect:/interlist";
    }

    @GetMapping("/intern-update/{id}")
    public String updateInternForm(@PathVariable("id") Long id, Model model) {
        Intern intern = internsServices.findById(id);
        model.addAttribute("intern", intern);
        return "intern-update";
    }

    @PostMapping("/intern-update")
    public String updateIntern(Intern intern) {
        internsServices.setIntern(intern);
        return "redirect:/interlist";
    }

    @GetMapping("/byIDInterns/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("byIDIntern", internsServices.findById(id));
        return "byIDInterns";
    }

    @GetMapping("intern-delete/{id}")
    public String deleteIntern(@PathVariable("id") Long id) {
        internsServices.deleteById(id);
        return "redirect:/interlist";
    }

}
