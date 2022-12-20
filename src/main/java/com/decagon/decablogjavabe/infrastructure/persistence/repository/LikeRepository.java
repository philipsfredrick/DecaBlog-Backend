package com.decagon.decablogjavabe.infrastructure.persistence.repository;

import com.decagon.decablogjavabe.domain.entities.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
}
