package com.decagon.decablogjavabe.infrastructure.controllers;

import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import com.decagon.decablogjavabe.domain.entities.CommentEntity;
import com.decagon.decablogjavabe.usercase.payload.request.CommentRequest;
import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import com.decagon.decablogjavabe.usercase.payload.response.MakeCommentResponse;
import com.decagon.decablogjavabe.usercase.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

    private final CommentService commentService;


//    @PostMapping("/makeComment/{id}")
//    public ResponseEntity<MakeCommentResponse> makeComment (@PathVariable("id") Long articleId, @RequestBody CommentRequest request){
//        MakeCommentResponse response = commentService.makeComment(articleId, request.getComment());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @PostMapping("/makeComment")
    public ResponseEntity<ApiResponse<MakeCommentResponse>> makeComment (@RequestBody CommentRequest request){
        MakeCommentResponse response = commentService.makeComment(request);
        ApiResponse<MakeCommentResponse> apiResponse = new ApiResponse<>("Comment created successfully",true, response);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/comments")
    public ResponseEntity<ApiResponse<List<CommentEntity>>> getAllComments() {
        return new ResponseEntity<>(new ApiResponse<>("Success", true, commentService.getAllComments()),HttpStatus.OK);
    }
}
