package com.security.demo.model.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> extends AbstractPersistable<T> {

    @CreationTimestamp
    protected LocalDateTime createDate;

    @UpdateTimestamp
    protected LocalDateTime lastUpdateDate;

}
