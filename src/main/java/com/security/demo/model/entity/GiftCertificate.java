package com.security.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "gift_certificate")
public class GiftCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gift_certificate_id", nullable = false)
    private Long id;

    private String name;
    private String description;
    private Integer price;
    private Integer duration;

    @CreationTimestamp
    private LocalDate createDate;

    @UpdateTimestamp
    private LocalDate lastUpdateDate;

}
