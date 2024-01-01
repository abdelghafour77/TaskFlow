package com.example.taskflow.controllers;

import com.example.taskflow.dto.responses.TaskResponse;
import com.example.taskflow.entities.Task;
import com.example.taskflow.services.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
@Tag(name = "Task Controller", description = "This is a Task API")
public class TaskController {

    final private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<TaskResponse>> getAllTasksOfLoggedUser() {
//        return "hh";
        return ResponseEntity.ok().body(taskService.getAllTasksOfLoggedUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PostMapping("")
    public ResponseEntity<Task> createTask(Task task) {
        return ResponseEntity.ok().body(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task task) {
        return ResponseEntity.ok().body(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
