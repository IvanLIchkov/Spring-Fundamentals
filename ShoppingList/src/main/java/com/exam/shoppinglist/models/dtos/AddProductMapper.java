package com.exam.shoppinglist.models.dtos;

import com.exam.shoppinglist.models.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddProductMapper {

    Product addDtoToEntity(ProductAddDto productAddDto);
}
