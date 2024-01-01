package com.example.taskflow.services;

import com.example.taskflow.dto.responses.TaskResponse;
import com.example.taskflow.entities.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();
    public List<TaskResponse> getAllTasksOfLoggedUser();
    public Task getTaskById(Long id);
    public Task createTask(Task task);
    public Task updateTask(Long id, Task task);
    public void deleteTask(Long id);
}
