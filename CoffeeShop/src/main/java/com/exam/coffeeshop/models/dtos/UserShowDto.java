package com.exam.coffeeshop.models.dtos;

import com.exam.coffeeshop.models.entities.User;

import java.io.Serializable;

public class UserShowDto implements Serializable {

    private User user;

    private Long numberOfOrders;

    public UserShowDto() {
    }

    public UserShowDto(User user, Long numberOfOrders) {
        this();
        this.user = user;
        this.numberOfOrders = numberOfOrders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(Long numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }
}
