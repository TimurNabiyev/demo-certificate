package com.security.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_gift_certificate")
public class GiftCertificate extends BaseEntity<Long> {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer duration;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;

}
