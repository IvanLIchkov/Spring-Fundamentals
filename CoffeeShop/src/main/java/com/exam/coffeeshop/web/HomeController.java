package com.exam.coffeeshop.web;

import com.exam.coffeeshop.models.dtos.ShowAllOrdersDto;
import com.exam.coffeeshop.models.dtos.UserShowDto;
import com.exam.coffeeshop.models.entities.Order;
import com.exam.coffeeshop.services.OrderService;
import com.exam.coffeeshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final OrderService orderService;
    private final UserService userService;

    public HomeController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @ModelAttribute("showUsers")
    public List<UserShowDto> userShowDtos(){
        return this.userService.showEmployeeOrderByNumOfOrders();
    }

    @ModelAttribute("time")
    public int time(){
        ShowAllOrdersDto showAllOrdersDto = new ShowAllOrdersDto();
        showAllOrdersDto.setOrders(this.orderService.allOrders());
        return showAllOrdersDto.getTime();
    }

    @ModelAttribute("allOrders")
    private List<Order> orders(){
        return this.orderService.allOrders();
    }

    @GetMapping("/home")
    private String home(){
        return "/home";
    }

}
