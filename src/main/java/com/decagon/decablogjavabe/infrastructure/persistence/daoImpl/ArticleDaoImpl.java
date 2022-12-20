package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.ArticleDao;
import com.decagon.decablogjavabe.domain.entities.AdminEntity;
import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import com.decagon.decablogjavabe.domain.entities.CategoryEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.ArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ArticleDaoImpl extends CrudDaoImpl<ArticleEntity, Long> implements ArticleDao {

    private final ArticleRepository articleRepository;

    public ArticleDaoImpl(ArticleRepository articleRepository) {
        super(articleRepository);
        this.articleRepository = articleRepository;
    }


    @Override
    public List<ArticleEntity> findArticleEntitiesByTitleAndAuthor(String Title, String Author) {
        return articleRepository.findArticleEntitiesByTitleAndAuthorIgnoreCase(Title, Author);
    }

    @Override
    public List<ArticleEntity> findArticleEntitiesByAdminEntities(AdminEntity entity) {
        return articleRepository.findArticleEntitiesByAdminEntity(entity);
    }

    @Override
    public List<ArticleEntity> findArticleEntitiesByDecadevsEntity(DecadevsEntity entity) {
        return articleRepository.findArticleEntitiesByDecadevsEntity(entity);
    }

    public List<ArticleEntity> findArticleEntitiesByCategory(Category category) {
        return articleRepository.findArticleEntitiesByCategory(category);
    }

    public List<ArticleEntity> findArticleEntitiesByCategoryAndDecadevs(CategoryEntity category, DecadevsEntity entity) {
        return articleRepository.findAllByCategoryEntityAndDecadevsEntity(category, entity);
    }


}
