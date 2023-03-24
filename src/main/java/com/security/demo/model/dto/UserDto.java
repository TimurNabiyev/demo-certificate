package com.security.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.security.demo.model.entity.User} entity
 */
public record UserDto(Long id,
                      String username,
                      String password,
                      String firstName,
                      String lastName,
                      LocalDateTime dob,
                      @JsonIgnore LocalDateTime createDate,
                      @JsonIgnore LocalDateTime lastUpdateDate) implements Serializable {
}