package com.exam.coffeeshop.models.dtos;

import com.exam.coffeeshop.models.entities.User;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@org.mapstruct.Mapper(componentModel = "spring")
public interface RegisterUserMapper {

    User userRegistrationDtoToUserEntity(UserRegistrationDto userRegistrationDto);
}
