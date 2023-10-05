package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/users")
@Controller
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDTO userRegistrationDTO(){
        return new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public  String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO userRegistrationDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            return "redirect:/users/register";
        }


        this.userService.registerUser(userRegistrationDto);
        return "redirect:/users/login";
    }
}
