package com.exam.battleships.web;

import com.exam.battleships.models.dtos.ShipsFightDto;
import com.exam.battleships.models.entities.Ship;
import com.exam.battleships.service.ShipService;
import com.exam.battleships.service.impl.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final HomeService homeService;

    public HomeController(ShipService shipService, HomeService homeService) {
        this.shipService = shipService;
        this.homeService = homeService;
    }

    @ModelAttribute("allShips")
    public List<Ship> allShips(){
        return shipService.allShips();
    }

    @ModelAttribute("userShips")
    public List<Ship> userShips(){
        return shipService.userShips();
    }

    @ModelAttribute("allShipsExceptUserOnes")
    public List<Ship> allShipsExceptUsersOnes(){
        return shipService.allOtherShipsExceptCurrentUserShip();
    }

    @ModelAttribute("shipsFightDto")
    public ShipsFightDto fight(){
        return new ShipsFightDto();
    }


    @GetMapping("/")
    public String loggedOutIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex(){
        return "home";
    }

    @PostMapping("/home")
    public String attack(ShipsFightDto ships){
        this.homeService.fire(ships.getAttackShipId(), ships.getDefenderShipId());
        return "redirect:/home";
    }
}
