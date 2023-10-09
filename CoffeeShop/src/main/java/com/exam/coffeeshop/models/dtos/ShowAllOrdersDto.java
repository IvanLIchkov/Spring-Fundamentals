package com.exam.coffeeshop.models.dtos;

import com.exam.coffeeshop.models.entities.Category;
import com.exam.coffeeshop.models.entities.Order;

import java.util.List;

public class ShowAllOrdersDto {

    private int time;

    private List<Order> orders;

    public int getTime() {
        return orders.stream().map(Order::getCategory)
                .mapToInt(Category::getNeededTime)
                .sum();
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
