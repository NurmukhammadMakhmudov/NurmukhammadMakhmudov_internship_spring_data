package com.example.nurmukhammad_internship_spring_data;

import com.example.nurmukhammad_internship_spring_data.controllers.employeesController;
import com.example.nurmukhammad_internship_spring_data.controllers.internsController;
import com.example.nurmukhammad_internship_spring_data.security.JwTokenProvider;
import com.example.nurmukhammad_internship_spring_data.services.EmployeesServices;
import com.example.nurmukhammad_internship_spring_data.services.InternsServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class NurmukhammadInternshipSpringDataApplicationTests {
    public static final Logger logger = LoggerFactory.getLogger(InternsServices.class);

    @Bean
    public static DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/nurmukhammad_internship");
        ds.setUsername("nurmukhammadmakhmudov");
        ds.setPassword("");
        return ds;
    }

    @Test
    public void contextLoads() {
        NurmukhammadInternshipSpringDataApplicationTests nurmukhammadInternshipSpringDataApplicationTests = new NurmukhammadInternshipSpringDataApplicationTests();
        nurmukhammadInternshipSpringDataApplicationTests.DBTest(dataSource());
    }

    public void DBTest(DataSource dataSource) {
        Supplier<String> StrSupplier
                = () -> {
            try {
                return String.valueOf(dataSource.getConnection().isValid(1000));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
        logger.info(StrSupplier);

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
@WebMvcTest(controllers = internsController.class)
class TestIntern {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InternsServices internsServices;

    @Test
    void testInternList() throws Exception {
        mockMvc.perform(get("/interlist").contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void testInternId() throws Exception {
        mockMvc.perform(get("/interlist/1").contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void testInternIdNotContainedButGettingResponse() throws Exception {
        mockMvc.perform(get("/interlist/53").contentType("application/json"))
                .andExpect(status().isOk());
    }


}

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TokenAuthenticationServiceTest {
    private final JwTokenProvider jwTokenProvider;
    @Autowired
    private MockMvc mvc;


    @Autowired
    TokenAuthenticationServiceTest(JwTokenProvider jwTokenProvider) {
        this.jwTokenProvider = jwTokenProvider;
    }

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(status().isForbidden());
    }

    @Test
    public void shouldGenerateAuthToken() throws Exception {

        String token = jwTokenProvider.createToken("Admin@admin.com", "ADMIN");

        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders.get("/api/users").header("Authorization", token)).andExpect(status().isOk());
    }

}
