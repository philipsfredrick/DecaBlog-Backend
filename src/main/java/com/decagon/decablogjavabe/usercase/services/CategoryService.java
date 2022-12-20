package com.decagon.decablogjavabe.usercase.services;


import com.decagon.decablogjavabe.usercase.payload.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    void saveToCategoryDatabase();
    List<CategoryResponse> getAllCategories();

}
