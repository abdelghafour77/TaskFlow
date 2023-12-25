package com.example.taskflow.services.impl;

import com.example.taskflow.entities.Task;
import com.example.taskflow.repositories.TaskRepository;
import com.example.taskflow.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
//        TODO: Implement this method
        return null;
    }

    @Override
    public Task getTaskById(Long id) {
//        TODO: Implement this method
        return null;
    }

    @Override
    public Task createTask(Task task) {
//        TODO: Implement this method
        return null;
    }

    @Override
    public Task updateTask(Long id, Task task) {
//        TODO: Implement this method
        return null;
    }

    @Override
    public void deleteTask(Long id) {
//        TODO: Implement this method
    }
}
