package com.exam.coffeeshop.services;

import com.exam.coffeeshop.models.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> allCategories();

    Category getCategoryById(Long id);
}
