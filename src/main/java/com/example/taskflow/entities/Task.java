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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private String dueDate;
    private String completedDate;


    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User assignedTo;

    @ManyToMany
    private List<Tag> tags;


}
