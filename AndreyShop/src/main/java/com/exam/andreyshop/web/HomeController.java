package com.exam.andreyshop.web;

import com.exam.andreyshop.models.entities.Item;
import com.exam.andreyshop.services.ItemService;
import com.exam.andreyshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;
    private final ItemService itemService;

    public HomeController(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    @ModelAttribute("countOfItems")
    public int count(){
        return this.itemService.allItems().size();
    }

    @ModelAttribute("allItems")
    public List<Item> items(){
        List<Item> items = this.itemService.allItems();
        return this.itemService.allItems();
    }

    @GetMapping("/home")
    public String home(){
        if(this.userService.isLogged()){
            return "/home";
        }
        return "redirect:/login";
    }

}
