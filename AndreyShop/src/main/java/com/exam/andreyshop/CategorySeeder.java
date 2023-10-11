package com.exam.andreyshop;

import com.exam.andreyshop.models.entities.Category;
import com.exam.andreyshop.models.enums.CategoryTypeEnum;
import com.exam.andreyshop.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.categoryRepository.count() ==0) {
            List<Category> list = Arrays.stream(CategoryTypeEnum.values())
                    .map(value -> new Category(value.name()))
                    .toList();

            this.categoryRepository.saveAll(list);
        }
    }
}
