package com.example.taskflow.dto.requests;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    private String name;
    private String description;
    private String status;
    private String priority;
    private String dueDate;
    private String completedDate;
    private String completedBy;
    private String assignedTo;
    private String tags;


}
