package com.linkedout.linkedout.web;

import com.linkedout.linkedout.models.dto.AddCompanyDto;
import com.linkedout.linkedout.models.entity.Company;
import com.linkedout.linkedout.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/companies")
public class AddCompanyController {

    private final CompanyService companyService;

    public AddCompanyController(CompanyService companyService){
        this.companyService = companyService;
    }


    @ModelAttribute("addCompanyDto")
    public AddCompanyDto addCompanyDto(){
        return new AddCompanyDto();
    }

    @GetMapping("/add")
    private String addCompany(){
        return "company-add";
    }

    @PostMapping("/add")
    private String addCompany(@Valid AddCompanyDto addCompanyDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addCompanyDto", addCompanyDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addCompanyDto", bindingResult);
            return "redirect:/companies/add";
        }
        this.companyService.registerNewCompany(addCompanyDto);
        return "redirect:/";
    }
}
