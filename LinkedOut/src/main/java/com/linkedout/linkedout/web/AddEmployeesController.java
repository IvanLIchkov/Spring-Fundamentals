package com.linkedout.linkedout.web;

import com.linkedout.linkedout.models.dto.AddEmployeeDto;
import com.linkedout.linkedout.models.entity.Company;
import com.linkedout.linkedout.models.enums.EducationLevelEnum;
import com.linkedout.linkedout.services.CompanyService;
import com.linkedout.linkedout.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class AddEmployeesController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    public AddEmployeesController(EmployeeService employeeService,
                                  CompanyService companyService) {

        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @ModelAttribute("educationLevel")
    public EducationLevelEnum[] educationLevel(){
        return EducationLevelEnum.values();
    }

    @ModelAttribute("availableCompanies")
    public List<Company> companies(){
        return this.companyService.getCompanies();
    }

    @ModelAttribute("addEmployeeDto")
    public AddEmployeeDto addEmployeeDto(){
        return new AddEmployeeDto();
    }

    @GetMapping("/add")
    public java.lang.String addEmployee(){
        return "/employee-add";
    }

    @PostMapping("/add")
    public java.lang.String addEmployee(AddEmployeeDto addEmployeeDto){
        employeeService.addEmployeeInCompany(addEmployeeDto);
        return "redirect:/";
    }
}
