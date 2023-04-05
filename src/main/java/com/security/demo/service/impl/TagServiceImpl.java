package com.security.demo.service.impl;


import com.security.demo.mapper.dto.TagMapper;
import com.security.demo.model.dto.TagDto;
import com.security.demo.model.entity.Tag;
import com.security.demo.model.request.RequestedTagStatus;
import com.security.demo.model.request.TagCreateRequest;
import com.security.demo.repository.TagRepository;
import com.security.demo.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;
    private final TagRepository tagRepository;

    @Override
    public List<TagDto> create(TagCreateRequest tagCreateRequest) {
        log.info("Saving tags... ");
        List<Tag> newTags = new ArrayList<>();
        List<String> existingTags = new ArrayList<>();

        tagCreateRequest.getTags().forEach((tagName, requestedTagStatus) -> {
            if (requestedTagStatus.equals(RequestedTagStatus.NEW)) {
                newTags.add(Tag.builder().name(tagName).build());
            } else {
                existingTags.add(tagName);
            }
        });

        List<Tag> tags = tagRepository.saveAll(newTags);
        tags.addAll(tagRepository.findAllByNameIn(existingTags));
        return tagMapper.toDtoList(tags);
    }

    @Override
    public List<TagDto> getAll() {
        log.info("Getting all");
        return tagMapper.toDtoList(tagRepository.findAll());
    }

    @Override
    public TagDto deleteOne(Long id) {
        log.info("Delete one Tag by id = {}", id);
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tag by id = " + id + " not found"));
        tagRepository.deleteById(id);
        return tagMapper.toDto(tag);
    }

    @Override
    public TagDto deleteOne(String name) {
        log.info("Delete one Tag by name = {}", name);
        Tag tag = tagRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Tag by name = " + name + " not found"));
        if (tag.getId() != null) {
            tagRepository.delete(tag);
        }
        return tagMapper.toDto(tag);
    }
}
