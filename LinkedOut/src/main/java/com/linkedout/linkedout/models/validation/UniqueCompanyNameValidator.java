package com.linkedout.linkedout.models.validation;

import com.linkedout.linkedout.repositories.CompanyRepository;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueCompanyNameValidator implements ConstraintValidator<UniqueCompanyName, String> {

    private final CompanyRepository companyRepository;

    public UniqueCompanyNameValidator(CompanyRepository companyRepository){

        this.companyRepository = companyRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.companyRepository.findByName(value).isEmpty();
    }
}
