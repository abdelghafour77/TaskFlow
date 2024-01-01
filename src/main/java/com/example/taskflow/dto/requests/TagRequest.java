package com.example.taskflow.dto.requests;

import com.example.taskflow.entities.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagRequest {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Description is required")
    private String description;


    public static Tag toEntity(TagRequest tagRequest) {
        return Tag
                .builder()
                .name(tagRequest.getName())
                .description(tagRequest.getDescription())
                .build();
    }
}
