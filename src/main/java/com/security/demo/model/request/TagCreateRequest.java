package com.security.demo.model.request;

import com.security.demo.model.dto.TagDto;
import lombok.Data;

import java.util.List;

@Data
public class TagCreateRequest {
    private List<TagDto> tagDtos;
}
