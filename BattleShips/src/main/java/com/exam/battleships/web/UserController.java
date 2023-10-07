package com.exam.battleships.web;

import com.exam.battleships.models.dtos.LoginDto;
import com.exam.battleships.models.dtos.UserRegisterDto;
import com.exam.battleships.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute("userRegisterDto")
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            return "redirect:/users/register";
        }
        this.userService.registerUser(userRegisterDto);
        return "redirect:/users/login";
    }

    @ModelAttribute("loginDto")
    public LoginDto loginDto(){
        return new LoginDto();
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDto loginDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDto", bindingResult);
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            return "redirect:/users/login";
        }
        if(!this.userService.login(loginDto)){
            redirectAttributes.addFlashAttribute("badCredentials", true);
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            return "redirect:/users/login";
        }
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(){
        this.userService.logOut();
        return "redirect:/";
    }
}
