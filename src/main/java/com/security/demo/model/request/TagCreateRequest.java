package com.security.demo.model.request;

import jakarta.validation.constraints.NotEmpty;
import com.security.demo.model.dto.TagDto;
import lombok.Data;
import org.apache.coyote.Request;

import java.util.List;
import java.util.Map;

@Data
public class TagCreateRequest {
    @NotEmpty
    private Map<String, RequestedTagStatus> tags;
}
