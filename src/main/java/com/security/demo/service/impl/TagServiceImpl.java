package com.security.demo.service.impl;


import com.security.demo.mapper.dto.TagMapper;
import com.security.demo.model.dto.TagDto;
import com.security.demo.model.request.TagCreateRequest;
import com.security.demo.repository.TagRepository;
import com.security.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;
    private final TagRepository tagRepository;

    @Override
    public List<TagDto> create(TagCreateRequest tagCreateRequest) {
        return null;
    }

    @Override
    public List<TagDto> getAll() {
        return null;
    }

    @Override
    public TagDto deleteOne(Long id) {
        return null;
    }

    @Override
    public TagDto deleteOne(String name) {
        return null;
    }
}
