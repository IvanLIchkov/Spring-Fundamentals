package com.exam.shoppinglist.web;

import com.exam.shoppinglist.models.dtos.ProductAddDto;
import com.exam.shoppinglist.models.entities.Category;
import com.exam.shoppinglist.repositories.CategoryRepository;
import com.exam.shoppinglist.services.ProductService;
import com.exam.shoppinglist.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public ProductController(ProductService productService, CategoryRepository categoryRepository, UserService userService) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    @ModelAttribute("allCategories")
    public List<Category> categories(){
        return this.categoryRepository.findAll();
    }

    @ModelAttribute("productAddDto")
    public ProductAddDto productAddDto(){
        return new ProductAddDto();
    }

    @GetMapping("/add")
    public String add(){
        if(this.userService.isLogged()){
            return "product-add";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@Valid ProductAddDto productAddDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddDto",  bindingResult);
            redirectAttributes.addFlashAttribute("productAddDto", productAddDto);
            return "redirect:/add";
        }

        this.productService.addProduct(productAddDto);
        return "redirect:/home";
    }
}
