package com.exam.battleships;

import com.exam.battleships.models.entities.Category;
import com.exam.battleships.models.enums.ShipNamesEnum;
import com.exam.battleships.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.categoryRepository.count() == 0){
            List<Category> categories = Arrays.stream(ShipNamesEnum.values())
                    .map(Category::new)
                    .toList();

            this.categoryRepository.saveAll(categories);
        }
    }
}
