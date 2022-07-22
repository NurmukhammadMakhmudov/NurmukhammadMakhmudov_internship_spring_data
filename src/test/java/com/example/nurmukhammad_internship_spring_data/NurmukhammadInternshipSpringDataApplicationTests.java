package com.example.nurmukhammad_internship_spring_data;

import com.example.nurmukhammad_internship_spring_data.controllers.employeesController;
import com.example.nurmukhammad_internship_spring_data.services.EmployeesServices;
import com.example.nurmukhammad_internship_spring_data.services.InternsServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




class NurmukhammadInternshipSpringDataApplicationTests {
    @Test
    public void contextLoads() {
    }

}
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = employeesController.class)

class TestEmployees {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeesServices employeesServices;
    @Test
    void testEmployeeList() throws Exception {
        mockMvc.perform(get("/employeelist").contentType("application/json"))
                .andExpect(status().isOk());
    }
    @Test
    void testEmployeeId() throws Exception {
        mockMvc.perform(get("/employeelist/1").contentType("application/json"))
                .andExpect(status().isOk());
    }
    @Test
    void testEmptyUrl() throws Exception {
        mockMvc.perform(get("/").contentType("application/json"))
                .andExpect(status().isNotFound());
    }
    @Test
    void testEmployeeIdNotContainedButGettingResponse() throws Exception {
        mockMvc.perform(get("/employeelist/53").contentType("application/json"))
                .andExpect(status().isOk());
    }


}

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = employeesController.class)

class TestInterns {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InternsServices internsServices;
    @Test
    void testEmployeeList() throws Exception {
        mockMvc.perform(get("/interlist").contentType("application/json"))
                .andExpect(status().isOk());
    }
    @Test
    void testEmployeeId() throws Exception {
        mockMvc.perform(get("/interlist/1").contentType("application/json"))
                .andExpect(status().isOk());
    }
    @Test
    void testEmptyUrl() throws Exception {
        mockMvc.perform(get("/").contentType("application/json"))
                .andExpect(status().isNotFound());
    }
    @Test
    void testEmployeeIdNotContainedButGettingResponse() throws Exception {
        mockMvc.perform(get("/interlist/53").contentType("application/json"))
                .andExpect(status().isOk());
    }


}