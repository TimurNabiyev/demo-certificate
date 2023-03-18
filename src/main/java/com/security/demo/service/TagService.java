package com.security.demo.service;

import com.security.demo.model.dto.TagDto;

public interface TagService {
    TagDto create(TagDto tagDto);
    TagDto getOne(Long id);
}
