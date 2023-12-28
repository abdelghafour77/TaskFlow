package com.example.taskflow.entities;

import com.example.taskflow.entities.enums.TaskPriority;
import com.example.taskflow.entities.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private String dueDate;
    private String completedDate;
    private String completedBy;
    private int createdBy;
    private String assignedTo;

    @ManyToMany
    private List<Tag> tags;


}
