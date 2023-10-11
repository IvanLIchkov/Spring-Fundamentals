package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.AddOfferDto;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService){
        this.offerService = offerService;
        this.brandService = brandService;
    }
//    @ModelAttribute("transmission")
//    public TransmissionEnum[] transmission(){
//        return TransmissionEnum.values();
//    }

    @ModelAttribute("addOfferDto")
    public AddOfferDto addOfferDto(){
        return new AddOfferDto();
    }

    @ModelAttribute("engine")
    public EngineEnum[] engine(){
        return EngineEnum.values();
    }

    @GetMapping("/all")
    public String all(){
        return "offers";
    }

    @GetMapping("/add")
    public String add(Model model){

        return "offer-add";
    }

    @PostMapping("/add")
    public String add(AddOfferDto addOfferDto){

        offerService.createOffer(addOfferDto);

        return "index";
    }

    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid){
        return "details";
    }
}
