package com.linkedout.linkedout.web;

import com.linkedout.linkedout.models.entity.Company;
import com.linkedout.linkedout.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class ShowCompaniesController {

    private final CompanyService companyService;

    public ShowCompaniesController(CompanyService companyService){

        this.companyService = companyService;
    }

    @GetMapping("/all")
    public String showCompanies(Model model){
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("companies", companies);
        return "company-all";
    }

//    @PostMapping("all")

}
