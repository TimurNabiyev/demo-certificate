package com.security.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_users")
public class User extends BaseEntity<Long> {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime dob;

}
