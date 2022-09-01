package com.example.nurmukhammad_internship_spring_data.repos;

import com.example.nurmukhammad_internship_spring_data.models.mongoDB.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    @Query(value = "{executor_id: '?0'}")
    List<Task> findByExecutor_id(String executor_id);

    @Query(value = "{user_created_task_id: '?0'}")
    List<Task> findByUser_created_task_id(String user_created_task_id);


}
