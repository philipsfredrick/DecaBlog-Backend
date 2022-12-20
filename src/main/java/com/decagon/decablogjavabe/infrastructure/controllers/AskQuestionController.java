package com.decagon.decablogjavabe.infrastructure.controllers;

import com.decagon.decablogjavabe.usercase.payload.request.AskQuestionRequest;
import com.decagon.decablogjavabe.usercase.payload.request.SpaceRequest;
import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import com.decagon.decablogjavabe.usercase.payload.response.Responder;
import com.decagon.decablogjavabe.usercase.services.AskQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskQuestionController {
    private final AskQuestionService askQuestionService;

    public AskQuestionController(AskQuestionService askQuestionService) {
        this.askQuestionService = askQuestionService;
    }

    @PostMapping("/api/create-question")
    public ResponseEntity<ApiResponse> createQuestion(@RequestBody AskQuestionRequest askRequest){
        return Responder.okayQuestions(askQuestionService.askQuestion(askRequest));
    }

}
