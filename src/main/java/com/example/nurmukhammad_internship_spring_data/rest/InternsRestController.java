package com.example.nurmukhammad_internship_spring_data.rest;

import com.example.nurmukhammad_internship_spring_data.models.Intern;
import com.example.nurmukhammad_internship_spring_data.models.mongoDB.Task;
import com.example.nurmukhammad_internship_spring_data.services.InternsServices;
import com.example.nurmukhammad_internship_spring_data.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('MENTOR')")
public class InternsRestController {

    private final InternsServices internsServices;
    private final TaskService taskService;

    public InternsRestController(InternsServices internsServices, TaskService taskService) {
        this.internsServices = internsServices;
        this.taskService = taskService;
    }

    @GetMapping("/interns")
    public ResponseEntity<List<Intern>> getAllRecords() {
        List<Intern> interns = internsServices.getAllRecords();
        return ResponseEntity.ok().body(interns);
    }


    @PostMapping("interns/{id}")
    public void deleteIntern(@PathVariable("id") Long id) {
        internsServices.deleteById(id);

    }

    @PostMapping("interns-create-task/{id}")
    public ResponseEntity<?> createTask(@PathVariable("id") Long id, @RequestBody Task task){
        task.setExecutor_id(String.valueOf(id));
        task.setUser_created_task_id(String.valueOf(internsServices.getID()));
        task.setDate_created(LocalDateTime.now());
        taskService.addTask(task);
        return ResponseEntity.ok("New Task Added");

    }
    @GetMapping("interns-get-tasks")
    public ResponseEntity<?> getAllTasks(){
//        taskService.findByTask_descriptionBetween()
        return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.OK);
    }
    @GetMapping("interns-get-task-by-executorID/{id}")
    public ResponseEntity<?> getTaskByExecutorID(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.getTaskByExecutorID(String.valueOf(id)), HttpStatus.OK);
    }

    @GetMapping("interns-get-task-by-creatorID/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.getTaskByCreatorID(String.valueOf(id)), HttpStatus.OK);
    }
}
