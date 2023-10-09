package com.exam.coffeeshop.services;

import com.exam.coffeeshop.models.dtos.AddOrderDto;
import com.exam.coffeeshop.models.entities.Order;

import java.util.List;

public interface OrderService {

    void addOrder(AddOrderDto addOrderDto);

    List<Order> allOrders();


    void removeReadyOrder(Long id);
}

