package com.example.taskflow.services;

import com.example.taskflow.dto.requests.TagRequest;
import com.example.taskflow.dto.responses.TagResponse;
import com.example.taskflow.entities.Tag;

import java.util.List;

public interface TagService {

    List<TagResponse> getAllTags();

    TagResponse getTagById(Long id);

    Tag getTagByName(String name);

    Boolean existsByName(String name);

    TagResponse createTag(TagRequest tagRequest);

    TagResponse updateTag(Long id, TagRequest tagRequest);

    void deleteTag(Long id);

}
