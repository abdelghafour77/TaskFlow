package com.example.taskflow.controllers;

import com.example.taskflow.entities.Task;
import com.example.taskflow.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {

    final private TaskService taskService;

    @GetMapping("")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }
}
