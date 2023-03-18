package com.security.demo.service.impl;


import com.security.demo.mapper.TagMapper;
import com.security.demo.model.dto.TagDto;
import com.security.demo.model.entity.Tag;
import com.security.demo.repository.TagRepository;
import com.security.demo.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Override
    public TagDto create(TagDto tagDto) {
        Tag tag = tagMapper.toEntity(tagDto);
        tagRepository.save(tag);
        return tagMapper.toDto(tag);
    }

    @Override
    public TagDto getOne(Long id) {
        return tagMapper.toDto(tagRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }
}
