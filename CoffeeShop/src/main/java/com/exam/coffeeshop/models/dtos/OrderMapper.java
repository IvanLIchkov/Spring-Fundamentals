package com.exam.coffeeshop.models.dtos;

import com.exam.coffeeshop.models.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order addOrderDtoToOrderEntity(AddOrderDto addOrderDto);
}
