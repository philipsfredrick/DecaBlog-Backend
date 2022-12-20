package com.decagon.decablogjavabe.usercase.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {
    private String categoryName;
    private long categoryId;
}
