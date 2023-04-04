package com.security.demo.service;

import com.security.demo.model.dto.TagDto;
import com.security.demo.model.request.TagCreateRequest;

import java.util.List;

public interface TagService {
    List<TagDto> create(TagCreateRequest tagCreateRequest);
    List<TagDto> getAll();
    TagDto deleteOne(Long id);
    TagDto deleteOne(String name);
}
