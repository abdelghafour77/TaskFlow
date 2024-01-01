package com.example.taskflow.dto.requests;

import com.example.taskflow.entities.Tag;
import com.example.taskflow.entities.Task;
import com.example.taskflow.entities.User;
import com.example.taskflow.entities.enums.TaskPriority;
import com.example.taskflow.entities.enums.TaskStatus;
import com.example.taskflow.services.TagService;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TaskRequest {


    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private String description;

    @NotNull
    @NotBlank
    private String status;

    @NotNull
    @NotBlank
    private String priority;

    @NotNull
    @NotBlank
    private String dueDate;

    @NotNull
    @NotBlank
    private String completedDate;

    @NotNull
    @NotBlank
    private String assignedTo;

    private List<String> tags;


    public static Task toEntity(TaskRequest taskRequest, TagService tagService) {

        List<Tag> tags = new ArrayList<>();
        for (String tag: taskRequest.getTags()) {
            tags.add(tagService.getTagByName(tag));
        }
        System.out.println(tags);
        Task task=Task.builder()
                .name(taskRequest.getName())
                .description(taskRequest.getDescription())
                .status(TaskStatus.valueOf(taskRequest.getStatus()))
                .priority(TaskPriority.valueOf(taskRequest.getPriority()))
                .dueDate(taskRequest.getDueDate())
                .completedDate(taskRequest.getCompletedDate())
                .assignedTo(User.builder().email(taskRequest.getAssignedTo()).build())
                .tags(tags)
                .build();
        return task ;
    }

}
