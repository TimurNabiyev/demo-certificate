package com.security.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tag")
public class Tag extends BaseEntity<Long> {

    @Column(unique = true, nullable = false)
    private String name;

}
