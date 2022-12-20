package com.decagon.decablogjavabe.usercase.payload.response;

import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriteArticleResponse {
    private String message;
    private String timeStamp;
    private ArticleEntity article;


}
