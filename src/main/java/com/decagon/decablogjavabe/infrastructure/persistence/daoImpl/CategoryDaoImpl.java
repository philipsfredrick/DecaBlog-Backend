package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.CategoryDao;
import com.decagon.decablogjavabe.domain.entities.CategoryEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.CategoryRepository;

import java.util.List;

public class CategoryDaoImpl extends CrudDaoImpl<CategoryEntity, Long> implements CategoryDao {

    private final CategoryRepository categoryRepository;

    public CategoryDaoImpl(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> findAllByCategoryName(Category categoryName) {
        return categoryRepository.findAllByCategory(categoryName);
    }
}


