package com.linkedout.linkedout.models.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueCompanyNameValidator.class)
public @interface UniqueCompanyName {

    String message() default "Invalid Company Name";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
