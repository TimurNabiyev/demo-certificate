package com.security.demo.service;

import com.security.demo.model.dto.TagDto;

import java.util.List;

public interface TagService {
    List<TagDto> create(List<TagDto> tagDto);
    List<TagDto> getAll();
}
