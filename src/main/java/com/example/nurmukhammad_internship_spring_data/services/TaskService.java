package com.example.nurmukhammad_internship_spring_data.services;

import com.example.nurmukhammad_internship_spring_data.models.mongoDB.Task;
import com.example.nurmukhammad_internship_spring_data.repos.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public  void addTask(Task task){
            taskRepository.save(task);
    }
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
    public List<Task> getTaskByExecutorID(String id){
        return taskRepository.findByExecutor_id(id);
    }

    public List<Task> getTaskByCreatorID(String id){
        return taskRepository.findByUser_created_task_id(id);
    }
}
