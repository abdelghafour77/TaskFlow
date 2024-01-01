package com.example.taskflow.dto.responses;

import com.example.taskflow.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TagResponse {

    private String name;
    private String description;

//  from task entity to task response
    public static TagResponse fromEntity(Tag tag) {
       return TagResponse
               .builder()
                .name(tag.getName())
                .description(tag.getDescription())
               .build();
    }

    public static List<TagResponse> fromListEntity(List<Tag> tags) {
        return tags.stream().map(tag -> TagResponse.builder()
                .name(tag.getName())
                .description(tag.getDescription())
                .build()).toList();
    }


}
