package com.security.demo.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GiftCertificateCreateRequest {

    @NotBlank
    private String name;

    private String description;

    @PositiveOrZero
    private BigDecimal price;

    @Positive
    private Integer durationInDays;

    @NotNull
    private TagCreateRequest tagCreateRequest;
}
