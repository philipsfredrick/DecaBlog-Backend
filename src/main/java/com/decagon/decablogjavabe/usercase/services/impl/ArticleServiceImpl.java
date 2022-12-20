package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.dao.AdminDao;
import com.decagon.decablogjavabe.domain.dao.AppUserDao;
import com.decagon.decablogjavabe.domain.dao.ArticleDao;
import com.decagon.decablogjavabe.domain.dao.DecadevsDao;
import com.decagon.decablogjavabe.domain.entities.*;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import com.decagon.decablogjavabe.infrastructure.configuration.security.UserDetails;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.CategoryRepository;
import com.decagon.decablogjavabe.usercase.payload.request.ArticleRequest;
import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import com.decagon.decablogjavabe.usercase.payload.response.ArticleResponse;
import com.decagon.decablogjavabe.usercase.payload.response.WriteArticleResponse;
import com.decagon.decablogjavabe.usercase.services.ArticleService;

import com.decagon.decablogjavabe.utils.LocalDateTimeConverter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import java.util.stream.Collectors;




@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final AppUserDao appUserDao;

    private final ArticleDao articleDao;
    private final AdminDao adminDao;
    private final CategoryRepository categoryRepository;
    private final DecadevsDao decadevsDao;
   @Override
    public WriteArticleResponse writeArticleForAdmin(ArticleRequest articleRequest, Long Id) {
        String userEmail = UserDetails.getLoggedInUserDetails();
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(userEmail);
        ArticleEntity articleEntity = new ArticleEntity();
        AdminEntity adminEntity = adminDao.getByAppUser(appUser);
       articleEntity.setTitle(articleRequest.getTitle());
       Category category = Category.valueOf(articleRequest.getCategory().toUpperCase());
        articleEntity.setCategory(category);
        articleEntity.setCategoryEntity(categoryRepository.findByCategory(category).orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Category not found")));
        articleEntity.setAuthor(articleRequest.getAuthor());
        articleEntity.setPicture(articleRequest.getPicture());
        articleEntity.setPostContent(articleRequest.getPostContent());
        articleEntity.setAdminEntity(adminEntity);
        articleDao.saveRecord(articleEntity);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm a"));
        return new WriteArticleResponse("success", timeStamp, articleEntity);
    }

    @Override
    public WriteArticleResponse writeArticleForDecadev(ArticleRequest articleRequest) {
        String userEmail = UserDetails.getLoggedInUserDetails();
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(userEmail);
        ArticleEntity articleEntity = new ArticleEntity();
        DecadevsEntity decadevsEntity = decadevsDao.getByAppUser(appUser);
        articleEntity.setTitle(articleRequest.getTitle());
        Category category = Category.valueOf(articleRequest.getCategory().toUpperCase());
        articleEntity.setCategory(category);
        articleEntity.setCategoryEntity(categoryRepository.findByCategory(category).orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Category not found with name " + category.name())));
        articleEntity.setAuthor(articleRequest.getAuthor());
        articleEntity.setPicture(articleRequest.getPicture());
        articleEntity.setPostContent(articleRequest.getPostContent());
        articleEntity.setDecadevsEntity(decadevsEntity);
        articleDao.saveRecord(articleEntity);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm a"));
        return new WriteArticleResponse("success", timeStamp, articleEntity);
    }

    @Override
    public List<ArticleResponse> getAllArticles() {

        List<ArticleEntity> articleEntity = articleDao.getAllRecords();
       return toResponse(articleEntity);
    }

    @Override
    public ApiResponse<List<ArticleResponse>> getAllArticlesByUser(Long id) {
        String userEmail = UserDetails.getLoggedInUserDetails();
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(userEmail);
        AdminEntity admin = adminDao.getByAppUser(appUser);
        DecadevsEntity decadev = decadevsDao.getByAppUser(appUser);
        List<ArticleEntity> articles;
        if (admin != null){
            articles = articleDao.findArticleEntitiesByAdminEntities(admin);
        }else {
            articles = articleDao.findArticleEntitiesByDecadevsEntity(decadev);
        }

        return new ApiResponse<>("Success", true, toResponse(articles));
    }

//    @Override
//    public List<ArticleEntity> getAllArticlesByCategory(Category category) {
//        return articleDao.findArticleEntitiesByCategory(category);
//    }

    @Override
    public List<ArticleResponse> getAllArticlesByCategory(Long id) {
        String userEmail = UserDetails.getLoggedInUserDetails();
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(userEmail);
        DecadevsEntity decadev = decadevsDao.getByAppUser(appUser);
        Category category = Category.getCategory(id);
        CategoryEntity categoryEntity = categoryRepository.findByCategory(category).orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND,"Category not found"));
        return toResponse(articleDao.findArticleEntitiesByCategoryAndDecadevs(categoryEntity, decadev));
    }

    private List<ArticleResponse> toResponse(List<ArticleEntity> articles){
        return articles.stream()
                .map(ar -> ArticleResponse.builder()
                        .articleId(ar.getId())
                        .title(ar.getTitle())
                        .postContent(ar.getPostContent())
                        .author(ar.getAuthor())
                        .category(ar.getCategoryEntity().getCategory().name())
                        .categoryId(ar.getCategoryEntity().getId())
                        .dateTime(ar.getCreatedAt().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm a")))
                        .numberOfComments(ar.getCommentEntities().size())
                        .numberOfLikes(ar.getLikeEntityList().size())
                        .picture(ar.getPicture())
                        .build()).collect(Collectors.toList());
    }
}
