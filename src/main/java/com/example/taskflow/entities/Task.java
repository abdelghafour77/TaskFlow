package com.example.taskflow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String status;
    private String priority;
    private String dueDate;
    private String completedDate;
    private String completedBy;
    private String createdBy;
    private String assignedTo;

    @ManyToMany
    private List<Tag> tags;


}
