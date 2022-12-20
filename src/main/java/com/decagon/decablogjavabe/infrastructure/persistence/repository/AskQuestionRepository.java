package com.decagon.decablogjavabe.infrastructure.persistence.repository;

import com.decagon.decablogjavabe.domain.entities.AskQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AskQuestionRepository extends JpaRepository<AskQuestionEntity, Long> {
}
