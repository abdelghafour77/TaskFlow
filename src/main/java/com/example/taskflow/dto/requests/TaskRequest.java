package com.example.taskflow.dto.requests;

import com.example.taskflow.entities.Tag;
import com.example.taskflow.entities.enums.TaskPriority;
import com.example.taskflow.entities.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private String description;

    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @NotNull
    @NotBlank
    private String dueDate;

    @NotNull
    @NotBlank
    private String completedDate;

    @NotNull
    @NotBlank
    private String completedBy;

    @NotNull
    @NotBlank
    private String assignedTo;

    @NotNull
    @NotBlank
    private List<Tag> tags;


}
