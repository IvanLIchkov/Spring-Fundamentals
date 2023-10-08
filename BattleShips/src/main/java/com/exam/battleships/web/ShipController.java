package com.exam.battleships.web;

import com.exam.battleships.models.dtos.AddShipDto;
import com.exam.battleships.models.entities.Category;
import com.exam.battleships.repositories.CategoryRepository;
import com.exam.battleships.service.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final CategoryRepository categoryRepository;
    private final ShipService shipService;

    public ShipController(CategoryRepository categoryRepository, ShipService shipService)     {
        this.categoryRepository = categoryRepository;
        this.shipService = shipService;
    }

    @ModelAttribute("addShipDto")
    public AddShipDto addShipDto(){
        return new AddShipDto();
    }

    @ModelAttribute("shipCategory")
    public List<Category> categories(){
        return this.categoryRepository.findAll();
    }

    @GetMapping("/add")
    public String addShip(){
        return "ship-add";
    }

    @PostMapping("/add")
    public String addShip(@Valid AddShipDto addShipDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShipDto", bindingResult);
            redirectAttributes.addFlashAttribute("addShipDto", addShipDto);
            return "redirect:/ships/add";
        }

        this.shipService.addShip(addShipDto);
        return "redirect:/home";
    }
}
