package com.exam.andreyshop.services.impl;

import com.exam.andreyshop.models.entities.Category;
import com.exam.andreyshop.repositories.CategoryRepository;
import com.exam.andreyshop.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }
}
