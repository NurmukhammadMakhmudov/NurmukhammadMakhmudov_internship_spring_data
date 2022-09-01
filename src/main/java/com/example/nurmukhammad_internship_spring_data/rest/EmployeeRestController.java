package com.example.nurmukhammad_internship_spring_data.rest;

import com.example.nurmukhammad_internship_spring_data.models.Employees;
import com.example.nurmukhammad_internship_spring_data.models.mongoDB.Task;
import com.example.nurmukhammad_internship_spring_data.services.EmployeesServices;
import com.example.nurmukhammad_internship_spring_data.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('MANAGER')")
public class EmployeeRestController {

    private final EmployeesServices employeesServices;

    private final TaskService taskService;

    @Autowired
    public EmployeeRestController(EmployeesServices employeesServices, TaskService taskService) {
        this.employeesServices = employeesServices;
        this.taskService = taskService;
    }

    @GetMapping("employees")
    @Secured("MANAGER")
    public ResponseEntity<List<Employees>> employees() {
        return ResponseEntity.ok().body( employeesServices.getAllRecords());
    }

    @PostMapping("employees/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public void deleteUser(@PathVariable("id") Long id) {
        employeesServices.deleteById(id);

    }

    @PostMapping("employees-create-task/{id}")
    public ResponseEntity<?> createTask(@PathVariable("id") Long id, @RequestBody Task task){
        task.setExecutor_id(String.valueOf(id));
        task.setUser_created_task_id(String.valueOf(employeesServices.getID()));
        task.setDate_created(LocalDateTime.now());
        taskService.addTask(task);
        return ResponseEntity.ok("New Task Added");

    }
    @GetMapping("employees-get-task-by-executorID/{id}")
    public ResponseEntity<?> getTaskByExecutorID(@PathVariable("id") Long id){
            return new ResponseEntity<>(taskService.getTaskByExecutorID(String.valueOf(id)), HttpStatus.OK);
    }

    @GetMapping("employees-get-task-by-creatorID/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.getTaskByCreatorID(String.valueOf(id)), HttpStatus.OK);
    }
}
