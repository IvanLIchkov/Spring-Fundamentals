package com.exam.shoppinglist.models.validations;

import com.exam.shoppinglist.repositories.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductNameValidator implements ConstraintValidator<ProductNameMatch, String> {

    private final ProductRepository productRepository;

    public ProductNameValidator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.productRepository.findByName(value).isEmpty();
    }
}
