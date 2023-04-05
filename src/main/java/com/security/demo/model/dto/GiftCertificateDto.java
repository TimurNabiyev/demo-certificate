package com.security.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link com.security.demo.model.entity.GiftCertificate} entity
 */
public record GiftCertificateDto(Long id,
                                 String name,
                                 String description,
                                 BigDecimal price,
                                 LocalDate expirationDate,
                                 List<TagDto> tags,
                                 @JsonIgnore Boolean isEnabled,
                                 @JsonIgnore LocalDateTime createDate,
                                 @JsonIgnore LocalDateTime lastUpdateDate) implements Serializable {
}