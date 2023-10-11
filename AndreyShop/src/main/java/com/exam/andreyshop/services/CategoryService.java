package com.exam.andreyshop.services;

import com.exam.andreyshop.models.entities.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long id);

    List<Category> getCategories();
}
