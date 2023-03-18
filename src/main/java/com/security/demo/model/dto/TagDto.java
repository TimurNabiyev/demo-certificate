package com.security.demo.model.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.security.demo.model.entity.Tag} entity
 */
public record TagDto(Long id, String name) implements Serializable {
}