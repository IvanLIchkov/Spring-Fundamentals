package com.linkedout.linkedout.web;

import com.linkedout.linkedout.util.LastUpdateOfDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @ModelAttribute("LastUpdate")
    public LastUpdateOfDatabase lastUpdateOfDatabase(){
        return new LastUpdateOfDatabase();
    }

    @GetMapping
    public String home(){
        return "/index";
    }

}
