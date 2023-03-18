package com.security.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.security.demo.model.entity.User} entity
 */
public record UserDto(Long id,
                      LocalDateTime createDate,
                      LocalDateTime lastModifiedDate,
                      String userName,
                      String password,
                      String firstName,
                      @JsonIgnore String lastName,
                      @JsonIgnore LocalDateTime dob) implements Serializable {
}