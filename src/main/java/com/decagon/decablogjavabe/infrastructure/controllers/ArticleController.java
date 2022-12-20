package com.decagon.decablogjavabe.infrastructure.controllers;

import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import com.decagon.decablogjavabe.usercase.payload.request.ArticleRequest;
import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import com.decagon.decablogjavabe.usercase.payload.response.ArticleResponse;
import com.decagon.decablogjavabe.usercase.payload.response.WriteArticleResponse;
import com.decagon.decablogjavabe.usercase.services.ArticleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
@Slf4j
@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class ArticleController {

   private final ArticleService articleService;

    @PostMapping("/{id}/writeArticle-admin")
    public ResponseEntity<WriteArticleResponse> writeArticleForAdmin(@RequestBody ArticleRequest articleRequest,  @PathVariable Long id) {
        WriteArticleResponse postResponse = articleService.writeArticleForAdmin(articleRequest, id);
        log.info("Successfully Created A Post with Title: {} ", articleRequest.getTitle());
        return new ResponseEntity<>(postResponse, CREATED);
    }

    @PostMapping("/writeArticle-decadev")
    public ResponseEntity<WriteArticleResponse> writeArticleForDecadev(@RequestBody ArticleRequest articleRequest) {
        WriteArticleResponse postResponse = articleService.writeArticleForDecadev(articleRequest);
        log.info("Successfully Created A Post with Title: {} ", articleRequest.getTitle());
        return new ResponseEntity<>(postResponse, CREATED);
    }

    @GetMapping("/allArticles")
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getAllArticles() {
        return new ResponseEntity<>(new ApiResponse<>("Success", true, articleService.getAllArticles()),HttpStatus.OK);
    }

    @GetMapping("/{id}/articles")
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getAllArticlesByUser(@PathVariable("id") Long id){
        ApiResponse<List<ArticleResponse>> allArticles = articleService.getAllArticlesByUser(id);
        return new ResponseEntity<>(allArticles, HttpStatus.OK);
    }



    @GetMapping("/find-articles/{categoryId}")
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getAllArticlesByCategory(@PathVariable("categoryId") long id) {
        List<ArticleResponse> allArticles = articleService.getAllArticlesByCategory(id);
        return new ResponseEntity<>(new ApiResponse<>("Success", true, allArticles), HttpStatus.OK);
    }
}
