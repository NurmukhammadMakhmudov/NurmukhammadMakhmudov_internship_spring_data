package com.example.nurmukhammad_internship_spring_data.models.mongoDB;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "task")
public class Task {
    public Task(String user_created_task_id, String executor_id, String task_description, LocalDateTime date_created) {
        this.user_created_task_id = user_created_task_id;
        this.executor_id = executor_id;
        this.task_description = task_description;
        this.date_created = date_created;
    }

    @Id
    private String id;
    private String user_created_task_id;
    private String executor_id;
    private String task_description;
    private LocalDateTime date_created;

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", user_created_task_id='" + user_created_task_id + '\'' +
                ", executor_id='" + executor_id + '\'' +
                ", task_description='" + task_description + '\'' +
                ", date_created=" + date_created +
                '}';
    }
}
