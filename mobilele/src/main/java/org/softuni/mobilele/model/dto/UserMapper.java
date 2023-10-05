package org.softuni.mobilele.model.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegistrationDTO userRegistrationDTO);
}
