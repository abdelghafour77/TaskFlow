package com.example.taskflow.seeder.dbSeeder;

import com.example.taskflow.dto.requests.TagRequest;
import com.example.taskflow.entities.Tag;
import com.example.taskflow.services.TagService;
import org.springframework.stereotype.Component;

@Component
public class TagSeeder {

    private final TagService tagService;

    private final TagRequest[] Tags=
            {
                    TagRequest.builder()
                            .name("Tag1")
                            .description("Tag1 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag2")
                            .description("Tag2 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag3")
                            .description("Tag3 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag4")
                            .description("Tag4 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag5")
                            .description("Tag5 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag6")
                            .description("Tag6 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag7")
                            .description("Tag7 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag8")
                            .description("Tag8 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag9")
                            .description("Tag9 description")
                            .build(),
                    TagRequest.builder()
                            .name("Tag10")
                            .description("Tag10 description")
                            .build(),
            };

    public TagSeeder(TagService tagService) {
        this.tagService = tagService;
    }

    private void log() {
        System.out.println("----------------------Tag----------------------");
    }

    public void seed() {
        this.log();
        for (TagRequest tag : Tags) {
            if (tagService.existsByName(tag.getName())) {
                System.out.println("Tag already exists");
            } else {
                System.out.println("Tag created: " + tagService.createTag(tag));
            }
        }
    }


}
