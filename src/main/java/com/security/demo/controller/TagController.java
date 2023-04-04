package com.security.demo.controller;

import com.security.demo.model.dto.TagDto;
import com.security.demo.model.request.TagCreateRequest;
import com.security.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<List<TagDto>> create(@RequestBody TagCreateRequest tagCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.create(tagCreateRequest));
    }

    @GetMapping
    public List<TagDto> getAll() {
        return tagService.getAll();
    }
}
