package com.example.taskflow.seeder.dbSeeder;

import com.example.taskflow.dto.requests.TaskRequest;
import com.example.taskflow.entities.enums.TaskPriority;
import com.example.taskflow.entities.enums.TaskStatus;
import com.example.taskflow.services.TaskService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskSeeder {

    private final TaskService taskService;
    private final TaskRequest[] taskRequests={
            TaskRequest.builder()
                    .name("Task1")
                    .description("Task1 description")
                    .assignedTo("abdelghafour.aouad0@gmail.com")
                    .status("TODO")
                    .priority("MEDIUM")
                    .tags(null)
                    .dueDate("2024-01-07")
                    .completedDate("2024-01-08")
                    .tags(List.of(new String[]{"tag1", "tag5", "tag9"}))
                    .build(),
            TaskRequest.builder()
                    .name("Task2")
                    .description("Task2 description")
                    .assignedTo("abdelghafour.aouad0@gmail.com")
                    .status("TODO")
                    .priority("MEDIUM")
                    .tags(List.of(new String[]{"tag4", "tag6","tag7"}))
                    .dueDate("2024-01-07")
                    .completedDate("2024-01-08")
                    .build(),
            TaskRequest.builder()
                    .name("Task3")
                    .description("Task3 description")
                    .assignedTo("abdelghafour.aouad0@gmail.com")
                    .status("TODO")
                    .priority("MEDIUM")
                    .tags(List.of(new String[]{"tag1", "tag3"}))
                    .dueDate("2024-01-07")
                    .completedDate("2024-01-08")
                    .build(),
            TaskRequest.builder()
                    .name("Task4")
                    .description("Task4 description")
                    .assignedTo("abdelghafour.aouad0@gmail.com")
                    .status("TODO")
                    .priority("MEDIUM")
                    .tags(List.of(new String[]{"tag1", "tag2", "tag10","tag8"}))
                    .dueDate("2024-01-07")
                    .completedDate("2024-01-08")
                    .build(),

    };

    public TaskSeeder(TaskService taskService) {
        this.taskService = taskService;
    }

    public void log() {
        System.out.println("----------------------Tasks----------------------");
    }

    public void seed() {
        this.log();

        for (TaskRequest task : taskRequests) {
            if(taskService.existsByName(task.getName())){
                System.out.println("Task already exists");
            }else{
                System.out.println("Task created: " + taskService.createTaskSeeder(task));
            }

        }
    }

}
