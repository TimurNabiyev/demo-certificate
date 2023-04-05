package com.security.demo.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Map;

@Data
public class TagCreateRequest {
    @NotEmpty
    private Map<String, RequestedTagStatus> tags;
}
