package com.example.taskflow.services.impl;

import com.example.taskflow.dto.requests.TaskRequest;
import com.example.taskflow.dto.responses.TaskResponse;
import com.example.taskflow.entities.Task;
import com.example.taskflow.entities.User;
import com.example.taskflow.repositories.TaskRepository;
import com.example.taskflow.services.TagService;
import com.example.taskflow.services.TaskService;
import com.example.taskflow.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final TagService tagService;

    public TaskServiceImpl(TaskRepository taskRepository, UserService userService, TagService tagService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.tagService = tagService;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<TaskResponse> getAllTasksOfLoggedUser() {
        String email = getLoggedUser();
        return TaskResponse.fromListEntity(taskRepository.findAllByEmail(email));

    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = taskRequest.toEntity(taskRequest,tagService);
        task.setCreatedBy(userService.getUserByEmail(getLoggedUser()));
        task.setAssignedTo(userService.getUserByEmail(taskRequest.getAssignedTo()));
        return TaskResponse.fromEntity(taskRepository.save(task));
    }
    public TaskResponse createTaskSeeder(TaskRequest taskRequest) {
        Task task = taskRequest.toEntity(taskRequest, tagService);
        task.setCreatedBy(userService.getUserByEmail("admin@mail.com"));
        task.setAssignedTo(userService.getUserByEmail(taskRequest.getAssignedTo()));

        System.out.println("aa");
        return TaskResponse.fromEntity(taskRepository.save(task));
    }


    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        return TaskResponse.fromEntity(taskRepository.save(TaskRequest.toEntity(taskRequest,tagService)));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public String getLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    @Override
    public boolean existsByName(String name) {
        return taskRepository.existsByName(name);
    }
}
