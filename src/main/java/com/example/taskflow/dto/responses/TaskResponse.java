package com.example.taskflow.dto.responses;

import com.example.taskflow.entities.Tag;
import com.example.taskflow.entities.Task;
import com.example.taskflow.entities.enums.TaskPriority;
import com.example.taskflow.entities.enums.TaskStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TaskResponse {


    private String name;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private String dueDate;
    private String completedDate;
    private String createdBy;
    private String assignedTo;

    private List<Tag> tags;

    public static TaskResponse fromEntity(Task task) {
        return TaskResponse
                .builder()
                .name(task.getName())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .dueDate(task.getDueDate())
                .completedDate(task.getCompletedDate())
                .createdBy(task.getCreatedBy().getEmail())
                .assignedTo(task.getAssignedTo().getEmail())
                .tags(task.getTags())
                .build();
    }

    public static List<TaskResponse> fromListEntity(List<Task> tasks) {
        return tasks.stream().map(task -> fromEntity(task)).toList();
    }
}
