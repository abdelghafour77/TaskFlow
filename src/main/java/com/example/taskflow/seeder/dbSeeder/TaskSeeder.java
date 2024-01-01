package com.example.taskflow.seeder.dbSeeder;

import com.example.taskflow.services.TaskService;
import org.springframework.stereotype.Component;

@Component
public class TaskSeeder {

    private final TaskService taskService;

    public TaskSeeder(TaskService taskService) {
        this.taskService = taskService;
    }

    public void log() {
        System.out.println("----------------------Tasks----------------------");
    }

    public void seed() {
        this.log();
    }

}
