package com.security.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.security.demo.model.entity.GiftCertificate} entity
 */
public record GiftCertificateDto(Long id,
                                 String name,
                                 String description,
                                 BigDecimal price,
                                 Integer duration,
                                 @JsonIgnore LocalDateTime createDate,
                                 @JsonIgnore LocalDateTime lastUpdateDate) implements Serializable {
}