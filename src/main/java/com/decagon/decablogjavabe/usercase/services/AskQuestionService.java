package com.decagon.decablogjavabe.usercase.services;

import com.decagon.decablogjavabe.domain.entities.AskQuestionEntity;
import com.decagon.decablogjavabe.usercase.payload.request.AskQuestionRequest;

public interface AskQuestionService {
    AskQuestionEntity askQuestion(AskQuestionRequest askQuestionRequest);
}
