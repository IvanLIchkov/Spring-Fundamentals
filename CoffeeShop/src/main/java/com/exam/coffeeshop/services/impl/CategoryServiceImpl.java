package com.exam.coffeeshop.services.impl;

import com.exam.coffeeshop.models.entities.Category;
import com.exam.coffeeshop.repositories.CategoryRepository;
import com.exam.coffeeshop.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> allCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.findById(id).get();
    }
}
