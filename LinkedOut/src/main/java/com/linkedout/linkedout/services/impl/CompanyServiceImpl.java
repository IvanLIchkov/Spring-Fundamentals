package com.linkedout.linkedout.services.impl;

import com.linkedout.linkedout.models.dto.AddCompanyDto;
import com.linkedout.linkedout.models.dto.Mapper;
import com.linkedout.linkedout.models.entity.Company;
import com.linkedout.linkedout.repositories.CompanyRepository;
import com.linkedout.linkedout.services.CompanyService;
import com.linkedout.linkedout.util.LastUpdateOfDatabase;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final Mapper mapper;
    private final LastUpdateOfDatabase lastUpdateOfDatabase;

    public CompanyServiceImpl(CompanyRepository companyRepository,
                              Mapper mapper,
                              LastUpdateOfDatabase lastUpdateOfDatabase){
        this.companyRepository = companyRepository;

        this.mapper = mapper;
        this.lastUpdateOfDatabase = lastUpdateOfDatabase;
    }

    public Company getCompany(String companyName){
        return this.companyRepository.findByName(companyName).get();
    }

    @Override
    public void registerNewCompany(AddCompanyDto addCompanyDto) {
        Company companyToPersist = this.mapper.addCompanyDtoToCompanyEntity(addCompanyDto);
//        this.companyRepository.save(companyToPersist);
        System.out.println(LocalDateTime.now());
        this.lastUpdateOfDatabase.setLastUpdate(LocalDateTime.now());
    }


    @Override
    public List<Company> getCompanies() {
        return this.companyRepository.findAll();
    }
}

