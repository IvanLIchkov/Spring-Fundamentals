package com.exam.coffeeshop.services.impl;

import com.exam.coffeeshop.models.dtos.AddOrderDto;
import com.exam.coffeeshop.models.dtos.OrderMapper;
import com.exam.coffeeshop.models.entities.Order;
import com.exam.coffeeshop.repositories.OrderRepository;
import com.exam.coffeeshop.services.CategoryService;
import com.exam.coffeeshop.services.OrderService;
import com.exam.coffeeshop.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CategoryService categoryService;
    private final UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CategoryService categoryService, UserService userService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void addOrder(AddOrderDto addOrderDto) {
        Order order = this.orderMapper.addOrderDtoToOrderEntity(addOrderDto);
        order.setCategory(this.categoryService.getCategoryById(addOrderDto.getCategoryId()));
        order.setEmployee(this.userService.getUserById());
        this.orderRepository.save(order);
    }

    @Override
    public List<Order> allOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public void removeReadyOrder(Long id) {
        this.orderRepository.deleteById(id);
    }

}
