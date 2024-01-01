package com.example.taskflow.services.impl;

import com.example.taskflow.dto.requests.TagRequest;
import com.example.taskflow.dto.responses.TagResponse;
import com.example.taskflow.entities.Tag;
import com.example.taskflow.repositories.TagRepository;
import com.example.taskflow.services.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<TagResponse> getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        return TagResponse.fromListEntity(tags);
    }

    @Override
    public TagResponse getTagById(Long id) {
        return TagResponse.fromEntity(tagRepository.getById(id));
    }

    @Override
    public TagResponse createTag(TagRequest tagRequest) {
        return TagResponse.fromEntity(tagRepository.save(TagRequest.toEntity(tagRequest)));
    }

    @Override
    public TagResponse updateTag(Long id, TagRequest tagRequest) {
        Tag tag = tagRepository.getById(id);
        tag.setName(tagRequest.getName());
        tag.setDescription(tagRequest.getDescription());
        return TagResponse.fromEntity(tagRepository.save(tag));
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Boolean existsByName(String name) {
        return tagRepository.existsByName(name);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }
}
