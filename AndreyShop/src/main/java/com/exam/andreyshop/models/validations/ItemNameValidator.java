package com.exam.andreyshop.models.validations;

import com.exam.andreyshop.repositories.ItemRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ItemNameValidator implements ConstraintValidator<ItemNameMatch, String> {

    private final ItemRepository itemRepository;

    public ItemNameValidator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.itemRepository.findByName(value).isEmpty();
    }
}
