package com.exam.shoppinglist.web;

import com.exam.shoppinglist.models.dtos.LogInDto;
import com.exam.shoppinglist.services.UserService;
import com.exam.shoppinglist.session.CurrentUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("logInDto")
    public LogInDto logInDto(){
        return new LogInDto();
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @PostMapping("/login")
    public String login(@Valid LogInDto logInDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.logInDto",  bindingResult);
            redirectAttributes.addFlashAttribute("logInDto", logInDto);
            return "redirect:/login";
        }
        boolean login = userService.login(logInDto);
        if(!login){
            redirectAttributes.addFlashAttribute("badCredentials", true);
            redirectAttributes.addFlashAttribute("logInDto", logInDto);
            return "redirect:/login";
        }
        this.userService.login(logInDto);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(){
        if(this.userService.isLogged()){
            return "redirect:/home";
        }
        this.userService.logOut();
        return "redirect:/login";
    }
}
