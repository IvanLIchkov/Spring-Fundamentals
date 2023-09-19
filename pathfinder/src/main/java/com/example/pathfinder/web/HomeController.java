package com.example.pathfinder.web;


import com.example.pathfinder.models.entities.Route;
import com.example.pathfinder.services.RouteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private RouteService route;

    @Autowired
    public HomeController(RouteService route) {
        this.route = route;
    }

    @GetMapping("/")
    public String home(Model model){
        Route mostCommented = route.getMostCommented();
        model.addAttribute("mostCommented", route);
        return "index";
    }
}
