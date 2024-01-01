package com.example.taskflow.services;

import com.example.taskflow.dto.requests.TaskRequest;
import com.example.taskflow.dto.responses.TaskResponse;
import com.example.taskflow.entities.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();
    public List<TaskResponse> getAllTasksOfLoggedUser();
    public Task getTaskById(Long id);
    public TaskResponse createTask(TaskRequest taskRequest);
    public TaskResponse createTaskSeeder(TaskRequest taskRequest);
    public TaskResponse updateTask(Long id, TaskRequest taskRequest);
    public void deleteTask(Long id);
    public boolean existsByName(String name);
}
