package com.exam.andreyshop.web;

import com.exam.andreyshop.models.dtos.AddItemDto;
import com.exam.andreyshop.models.entities.Category;
import com.exam.andreyshop.models.entities.Item;
import com.exam.andreyshop.models.enums.GenderEnum;
import com.exam.andreyshop.services.CategoryService;
import com.exam.andreyshop.services.ItemService;
import com.exam.andreyshop.services.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper mapper;

    public ItemController(ItemService itemService, CategoryService categoryService, UserService userService, ModelMapper mapper) {
        this.itemService = itemService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @ModelAttribute("genders")
    public GenderEnum[] genders(){
        return GenderEnum.values();
    }

    @ModelAttribute("categoriesList")
    public List<Category> categories(){

        List<Category> categories = categoryService.getCategories();
        return categoryService.getCategories();
    }

    @ModelAttribute("addItemDto")
    private AddItemDto addItemDto(){
        return new AddItemDto();
    }

    @GetMapping("/add")
    public String add(){
        if(this.userService.isLogged()){
            return "add-item";
        }
        return "redirect:/login";
    }

    @PostMapping("/add")
    public String add(@Valid AddItemDto addItemDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addItemDto", bindingResult);
            redirectAttributes.addFlashAttribute("addItemDto", addItemDto);
            return "redirect:/add";
        }


        this.itemService.addItem(addItemDto);
        return "redirect:/home";

    }

    @ModelAttribute("detailItem")
    public Item item(Item item){
        return item;
    }
    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable String id, ModelAndView model){
        Item item = this.itemService.getItem(Long.valueOf(id));
        model.setViewName("details-item");
        model.addObject("detailItem", item);
        return model;
    }
}
