package com.decagon.decablogjavabe.usercase.payload.request;

import com.decagon.decablogjavabe.domain.entities.enums.Category;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    private String title;
    private String picture;
    private String author;
    private String postContent;
    private String category;
    private Long id;
}
