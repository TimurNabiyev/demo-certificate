package com.security.demo.service.impl;


import com.security.demo.mapper.dto.TagMapper;
import com.security.demo.model.dto.TagDto;
import com.security.demo.model.entity.Tag;
import com.security.demo.repository.TagRepository;
import com.security.demo.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Override
    public List<TagDto> create(List<TagDto> tagDtoList) {
        return tagMapper.toDtoList(tagRepository.saveAll(tagMapper.toEntityList(tagDtoList)));
    }

    @Override
    public List<TagDto> getAll() {
        return tagMapper.toDtoList(tagRepository.findAll());
    }
}
