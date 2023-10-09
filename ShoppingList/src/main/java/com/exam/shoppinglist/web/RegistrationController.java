package com.exam.shoppinglist.web;

import com.exam.shoppinglist.models.dtos.RegisterUserDto;
import com.exam.shoppinglist.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerUserDto")
    private RegisterUserDto registerUserDto(){
        return new RegisterUserDto();
    }

    @GetMapping("/register")
    public String register(){
        return "/register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterUserDto registerUserDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDto",  bindingResult);
            redirectAttributes.addFlashAttribute("registerUserDto", registerUserDto);
            return "redirect:register";
        }

        this.userService.registerUser(registerUserDto);
        return "redirect:/login";
    }
}
