package com.exam.shoppinglist.models.dtos;

import com.exam.shoppinglist.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper {

    User registerDtoToUserEntity(RegisterUserDto registerUserDto);
}
