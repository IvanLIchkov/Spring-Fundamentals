package com.linkedout.linkedout.services;

import com.linkedout.linkedout.models.dto.AddCompanyDto;
import com.linkedout.linkedout.models.entity.Company;

import java.util.List;

public interface CompanyService {

    void registerNewCompany(AddCompanyDto addCompanyDto);

    List<Company> getCompanies();
}
