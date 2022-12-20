package com.decagon.decablogjavabe.domain.dao;

import com.decagon.decablogjavabe.domain.entities.CategoryEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Category;

import java.util.List;


public interface CategoryDao extends CrudDao <CategoryEntity, Long> {

    List<CategoryEntity> findAllByCategoryName(Category category);

}
