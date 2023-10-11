package com.exam.andreyshop.services;

import com.exam.andreyshop.models.dtos.AddItemDto;
import com.exam.andreyshop.models.entities.Item;

import java.util.List;

public interface ItemService {

    void addItem(AddItemDto addItemDto);

    List<Item> allItems();

    Item getItem(Long id);
}
