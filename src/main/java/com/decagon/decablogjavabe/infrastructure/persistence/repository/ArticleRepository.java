package com.decagon.decablogjavabe.infrastructure.persistence.repository;

import com.decagon.decablogjavabe.domain.entities.AdminEntity;
import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import com.decagon.decablogjavabe.domain.entities.CategoryEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findArticleEntitiesByTitleAndAuthorIgnoreCase(String Title, String Author);

    List<ArticleEntity> findArticleEntitiesByAdminEntity(AdminEntity entity);

    List<ArticleEntity> findArticleEntitiesByDecadevsEntity(DecadevsEntity entity);

    List<ArticleEntity> findArticleEntitiesByCategory(Category category);

    List<ArticleEntity> findAllByCategoryEntityAndDecadevsEntity(CategoryEntity category, DecadevsEntity entity);
}
