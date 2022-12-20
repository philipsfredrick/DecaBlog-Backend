package com.decagon.decablogjavabe.infrastructure.persistence.repository;

import com.decagon.decablogjavabe.domain.entities.CategoryEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAllByCategory(Category category);
    Optional<CategoryEntity> findByCategory(Category category);

}

