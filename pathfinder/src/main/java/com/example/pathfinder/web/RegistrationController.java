package com.example.pathfinder.web;

import com.example.pathfinder.models.dtos.UserRegistrationDto;
import com.example.pathfinder.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegistrationController {

    private AuthenticationService authService;

    public RegistrationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto initForm(){
        return new UserRegistrationDto();
    }

    @GetMapping("/register")
    public String register(){
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
        this.authService.register(userRegistrationDto);
        return "redirect:/users/login";
    }
}
