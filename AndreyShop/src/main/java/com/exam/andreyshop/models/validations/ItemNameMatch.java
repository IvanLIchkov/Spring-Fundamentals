package com.exam.andreyshop.models.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ItemNameValidator.class)
public @interface ItemNameMatch {

    String message() default "Name has been already added!";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
