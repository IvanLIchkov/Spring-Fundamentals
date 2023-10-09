package com.exam.shoppinglist.web;

import com.exam.shoppinglist.models.entities.Product;
import com.exam.shoppinglist.services.ProductService;
import com.exam.shoppinglist.services.UserService;
import com.exam.shoppinglist.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;
    private final ProductService productService;

    public HomeController(UserService currentUser, ProductService productService) {
        this.userService = currentUser;
        this.productService = productService;
    }

    @ModelAttribute("totalPrice")
    private BigDecimal price(){
        return this.productService.allProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @ModelAttribute("allProducts")
    private List<Product> products(){
        return this.productService.allProducts();
    }

    @GetMapping("/home")
    public String home(){
        if(this.userService.isLogged()){
            return "/home";
        }
        return "/index";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable String id){
        this.productService.buyProduct(Long.valueOf(id));
        return "redirect:/home";
    }

    @GetMapping("/buyAll")
    public String buyAll(){
        this.productService.buyAll();
        return "redirect:/home";
    }
}
