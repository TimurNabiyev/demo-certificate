package com.security.demo.controller;

import com.security.demo.model.dto.TagDto;
import com.security.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping
    public TagDto create(@RequestBody TagDto tagDto) {
        return tagService.create(tagDto);
    }

    @GetMapping("/{id}")
    public TagDto getOne(@PathVariable Long id) {
        return tagService.getOne(id);
    }
}
