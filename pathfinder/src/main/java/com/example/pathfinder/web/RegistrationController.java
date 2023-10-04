package com.example.pathfinder.web;

import com.example.pathfinder.models.dtos.UserRegistrationDto;
import com.example.pathfinder.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegistrationController {


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userRegistrationDto", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDto userRegistrationDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto",bindingResult);
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);

            return "redirect:/users/register";

        }
        return "redirect:/users/login";
    }
}
