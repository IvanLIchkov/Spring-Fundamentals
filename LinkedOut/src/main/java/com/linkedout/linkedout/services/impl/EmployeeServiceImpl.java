package com.linkedout.linkedout.services.impl;

import com.linkedout.linkedout.models.dto.AddEmployeeDto;
import com.linkedout.linkedout.models.entity.Employee;
import com.linkedout.linkedout.repositories.EmployeeRepository;
import com.linkedout.linkedout.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private ModelMapper mapper;
    private CompanyServiceImpl companyService   ;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(ModelMapper mapper, CompanyServiceImpl companyService, EmployeeRepository employeeRepository) {
        this.mapper = mapper;
        this.companyService = companyService;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void addEmployeeInCompany(AddEmployeeDto addEmployeeDto) {
        Employee employeeToPersist = this.mapper.map(addEmployeeDto, Employee.class);
        employeeToPersist.setCompany(companyService.getCompany(addEmployeeDto.getCompanyName()));
        this.employeeRepository.save(employeeToPersist);
    }
}
