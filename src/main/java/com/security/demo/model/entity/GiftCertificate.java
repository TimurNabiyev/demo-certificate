package com.security.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "gift_certificate")
public class GiftCertificate extends BaseEntityAudit<Long> {

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime expirationDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "certificate_has_tag",
            joinColumns = @JoinColumn(name = "certificate_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false))
    private List<Tag> tags;
}
