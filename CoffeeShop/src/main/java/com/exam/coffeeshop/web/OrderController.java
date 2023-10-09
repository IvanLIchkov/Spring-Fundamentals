package com.exam.coffeeshop.web;

import com.exam.coffeeshop.models.dtos.AddOrderDto;
import com.exam.coffeeshop.models.entities.Category;
import com.exam.coffeeshop.services.CategoryService;
import com.exam.coffeeshop.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrderController {

    private final CategoryService categoryService;
    private final OrderService orderService;

    public OrderController(CategoryService categoryService, OrderService orderService) {
        this.categoryService = categoryService;
        this.orderService = orderService;
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return this.categoryService.allCategories();
    }

    @ModelAttribute("addOrderDto")
    public AddOrderDto addOrderDto(){
        return new AddOrderDto();
    }

    @GetMapping("/add")
    public String add(){
        return "order-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddOrderDto addOrderDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOrderDto", bindingResult);
            redirectAttributes.addFlashAttribute("addOrderDto", addOrderDto);
            return "redirect:/add";
        }
        this.orderService.addOrder(addOrderDto);
        return "redirect:/home";
    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable String id){
        this.orderService.removeReadyOrder(Long.valueOf(id));
        return "redirect:/home";
    }
}
