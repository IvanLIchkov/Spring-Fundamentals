package com.exam.coffeeshop;

import com.exam.coffeeshop.models.entities.Category;
import com.exam.coffeeshop.models.enums.CategoryNameEnum;
import com.exam.coffeeshop.repositories.CategoryRepository;
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
        if(this.categoryRepository.count()==0){
            List<Category> categories = Arrays.stream(CategoryNameEnum.values())
                    .map(c ->{
                        if(c.equals(CategoryNameEnum.Cake)){
                            return new Category().setName(c.name()).setNeededTime(10);
                        }else if(c.equals(CategoryNameEnum.Other)){
                            return new Category().setName(c.name()).setNeededTime(5);
                        } else if (c.equals(CategoryNameEnum.Coffee)) {
                            return new Category().setName(c.name()).setNeededTime(2);
                        }else{
                            return new Category().setName(c.name()).setNeededTime(1);
                        }
                    }).toList();
            this.categoryRepository.saveAll(categories);
        }
    }
}
