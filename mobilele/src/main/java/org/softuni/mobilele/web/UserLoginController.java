package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController (UserService userService){
        this.userService = userService;
    }

    @ModelAttribute("userLoginDto")
    public UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logoutUser();
        return "index";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO userLoginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || !this.userService.loginUser(userLoginDTO)){
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            bindingResult.rejectValue("password", "InvalidPasswordError", "Invalid Password.");
            return "redirect:/users/login";
        }

        return "index";
    }

}
