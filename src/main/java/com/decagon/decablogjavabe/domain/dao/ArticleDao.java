package com.decagon.decablogjavabe.domain.dao;

import com.decagon.decablogjavabe.domain.entities.AdminEntity;
import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import com.decagon.decablogjavabe.domain.entities.CategoryEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;

import java.util.List;

public interface ArticleDao extends CrudDao<ArticleEntity, Long>{


    List<ArticleEntity> findArticleEntitiesByTitleAndAuthor(String Title, String Author);

    List<ArticleEntity> findArticleEntitiesByAdminEntities(AdminEntity entity);

    List<ArticleEntity> findArticleEntitiesByDecadevsEntity(DecadevsEntity entity);

    List<ArticleEntity> findArticleEntitiesByCategory(Category category);

    List<ArticleEntity> findArticleEntitiesByCategoryAndDecadevs(CategoryEntity category, DecadevsEntity entity);

}
