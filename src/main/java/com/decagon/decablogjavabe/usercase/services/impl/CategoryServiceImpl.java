package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.dao.CategoryDao;
import com.decagon.decablogjavabe.domain.entities.ArticleEntity;
import com.decagon.decablogjavabe.domain.entities.CategoryEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.CategoryDaoImpl;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.CategoryRepository;
import com.decagon.decablogjavabe.usercase.payload.response.CategoryResponse;
import com.decagon.decablogjavabe.usercase.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void saveToCategoryDatabase() {
        List<String> categoryList = new ArrayList<>(Arrays.asList("PYTHON", "NODEJS", "JAVA", "REACT", "ANDROID", "ANGULAR", "PHP_LARAVEL", "MYSQL"));

        for (String category : categoryList) {
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setCategory(Category.valueOf(category));
            categoryRepository.save(categoryEntity);
        }
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream().map(c -> CategoryResponse.builder()
                .categoryId(c.getId())
                .categoryName(c.getCategory().name())
                .build()).collect(Collectors.toList());
    }
}
