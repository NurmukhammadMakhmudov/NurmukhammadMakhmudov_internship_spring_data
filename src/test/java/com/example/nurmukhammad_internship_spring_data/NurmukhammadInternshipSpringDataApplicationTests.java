package com.example.nurmukhammad_internship_spring_data;

import com.example.nurmukhammad_internship_spring_data.controllers.employeesController;
import com.example.nurmukhammad_internship_spring_data.models.employees;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = employeesController.class)
@SpringBootTest
class NurmukhammadInternshipSpringDataApplicationTests {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private employees empl;
//    @Test
//    void contextLoads() throws Exception {
//    mockMvc.perform(get("/employeelist/1")
//                    .contentType("employees"))
//            .andExpect(status().isOk());
//
//    }

}
