package com.security.demo.controller;

import com.security.demo.model.dto.TagDto;
import com.security.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping
    public List<TagDto> create(@RequestBody List<TagDto> tagDtos) {
        return tagService.create(tagDtos);
    }

    @GetMapping("/{id}")
    public List<TagDto> getAll() {
        return tagService.getAll();
    }
}
