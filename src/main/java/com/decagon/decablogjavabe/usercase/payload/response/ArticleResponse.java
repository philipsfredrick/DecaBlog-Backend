package com.decagon.decablogjavabe.usercase.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponse {
    private long articleId;
    private String category;
    private long categoryId;
    private String title;
    private String picture;
    private String author;
    private String postContent;
    private String dateTime;
    private int numberOfLikes;
    private int numberOfComments;
}
