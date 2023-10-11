package com.exam.andreyshop.web;

import com.exam.andreyshop.models.dtos.LoginUserDto;
import com.exam.andreyshop.models.dtos.RegisterUserDto;
import com.exam.andreyshop.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("registerUserDto")
    public RegisterUserDto registerUserDto(){
        return new RegisterUserDto();
    }


    @GetMapping("/register")
    private String register(){
        return "register";
    }

    @PostMapping("register")
    private String register(@Valid RegisterUserDto registerUserDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDto", bindingResult);
            redirectAttributes.addFlashAttribute("registerUserDto", registerUserDto);
            return "redirect:/register";
        }
        this.userService.registerUser(registerUserDto);
        return "redirect:/login";
    }

    @ModelAttribute("loginUserDto")
    public LoginUserDto loginUserDto(){
        return new LoginUserDto();
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginUserDto loginUserDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginUserDto", bindingResult);
            redirectAttributes.addFlashAttribute("loginUserDto", loginUserDto);
            return "redirect:/login";
        }
        boolean logged = this.userService.loginUser(loginUserDto);

        if(!logged){
            redirectAttributes.addFlashAttribute("wrongCredentials", true);
            redirectAttributes.addFlashAttribute("loginUserDto", loginUserDto);
            return "redirect:/login";
        }
        this.userService.loginUser(loginUserDto);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(){
        this.userService.logOut();
        return "redirect:/";
    }
}
