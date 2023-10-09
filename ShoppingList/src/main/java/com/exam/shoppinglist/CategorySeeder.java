package com.exam.shoppinglist;

import com.exam.shoppinglist.models.entities.Category;
import com.exam.shoppinglist.models.enums.CategoryTypeEnum;
import com.exam.shoppinglist.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.categoryRepository.count() == 0){
            List<Category> collect = Arrays.stream(CategoryTypeEnum.values())
                    .map(Category::new)
                    .toList();
            this.categoryRepository.saveAll(collect);
        }
    }
}
