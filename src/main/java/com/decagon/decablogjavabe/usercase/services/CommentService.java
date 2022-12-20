package com.decagon.decablogjavabe.usercase.services;

import com.decagon.decablogjavabe.domain.entities.CommentEntity;
import com.decagon.decablogjavabe.usercase.payload.request.CommentRequest;
import com.decagon.decablogjavabe.usercase.payload.response.MakeCommentResponse;

import java.util.List;

public interface CommentService {
    List<CommentEntity> getAllComments();

    MakeCommentResponse makeComment(CommentRequest request);
}
