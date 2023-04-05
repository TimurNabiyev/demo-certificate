package com.security.demo.repository;

import com.security.demo.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Boolean existsByName(String name);
    List<Tag> findAllByNameIn(List<String> name);
    Optional<Tag> findByName(String name);
}
