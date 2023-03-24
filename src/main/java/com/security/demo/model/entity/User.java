package com.security.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tb_users_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    @CreationTimestamp
    protected LocalDateTime createDate;

    @UpdateTimestamp
    protected LocalDateTime lastUpdateDate;

}
