package com.example.taskflow.controllers;

import com.example.taskflow.dto.requests.TagRequest;
import com.example.taskflow.dto.responses.TagResponse;
import com.example.taskflow.services.TagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
@AllArgsConstructor
@Tag(name = "Tag Controller", description = "This is a Tag API")
public class TagController {

    final private TagService tagService;

//   {
//    @Operation(
//            description = "Get endpoint for manager",
//            summary = "This is a summary for management get endpoint",
//            responses = {
//                    @ApiResponse(
//                            description = "Success",
//                            responseCode = "200"
//                    ),
//                    @ApiResponse(
//                            description = "Unauthorized / Invalid Token",
//                            responseCode = "403"
//                    )
//            }
//
//    )
//    }

    @GetMapping("/")
    public List<TagResponse> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public TagResponse getTagById(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @PostMapping("/")
    public TagResponse createTag(@Valid @RequestBody TagRequest tagRequest) {
        return tagService.createTag(tagRequest);
    }

    @PutMapping("/{id}")
    public TagResponse updateTag(@PathVariable Long id,@Valid @RequestBody TagRequest tagRequest) {
        return tagService.updateTag(id, tagRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }


}
