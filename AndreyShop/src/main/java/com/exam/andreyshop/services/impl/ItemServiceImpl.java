package com.exam.andreyshop.services.impl;

import com.exam.andreyshop.models.dtos.AddItemDto;
import com.exam.andreyshop.models.entities.Item;
import com.exam.andreyshop.repositories.ItemRepository;
import com.exam.andreyshop.services.CategoryService;
import com.exam.andreyshop.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper mapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper mapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @Override
    public void addItem(AddItemDto addItemDto) {
        Item itemToPersist = this.mapper.map(addItemDto, Item.class);
        itemToPersist.setCategory(categoryService.getCategoryById(addItemDto.getCategoryId()));
        this.itemRepository.save(itemToPersist);
    }

    @Override
    public List<Item> allItems() {

        return this.itemRepository.findAll();
    }

    @Override
    public Item getItem(Long id){
        return this.itemRepository.findById(id).get();
    }
}
