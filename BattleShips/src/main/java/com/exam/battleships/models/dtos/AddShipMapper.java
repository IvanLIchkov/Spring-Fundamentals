package com.exam.battleships.models.dtos;

import com.exam.battleships.models.entities.Ship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddShipMapper {

    Ship addShipDtoToShipEntity(AddShipDto addShipDto);
}
