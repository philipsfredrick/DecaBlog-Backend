package com.decagon.decablogjavabe.usercase.services;

import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import com.decagon.decablogjavabe.usercase.payload.request.ArticleRequest;
import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import com.decagon.decablogjavabe.usercase.payload.response.ArticleResponse;
import com.decagon.decablogjavabe.usercase.payload.response.WriteArticleResponse;

import java.util.List;

public interface ArticleService {
    WriteArticleResponse writeArticleForAdmin(ArticleRequest articleRequest, Long Id);
    WriteArticleResponse writeArticleForDecadev(ArticleRequest articleRequest);

    List<ArticleResponse> getAllArticles();



    ApiResponse<List<ArticleResponse>> getAllArticlesByUser(Long id);

//    List<ArticleEntity> getAllArticlesByCategory(Category category);
    List<ArticleResponse> getAllArticlesByCategory(Long id);

}
