package com.linkedout.linkedout.models.dto;

import com.linkedout.linkedout.models.entity.Company;
import com.linkedout.linkedout.models.entity.Employee;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    Company addCompanyDtoToCompanyEntity(AddCompanyDto addCompanyDto);

}
