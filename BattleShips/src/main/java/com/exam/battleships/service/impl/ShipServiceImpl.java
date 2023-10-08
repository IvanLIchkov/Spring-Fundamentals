package com.exam.battleships.service.impl;

import com.exam.battleships.models.dtos.AddShipDto;
import com.exam.battleships.models.dtos.AddShipMapper;
import com.exam.battleships.models.entities.Ship;
import com.exam.battleships.repositories.ShipRepository;
import com.exam.battleships.repositories.UserRepository;
import com.exam.battleships.service.CategoryService;
import com.exam.battleships.service.ShipService;
import com.exam.battleships.session.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final CurrentUser currentUser;
    private final AddShipMapper addShipMapper;
    private final CategoryService categoryService;
    private final UserRepository userRepository;

    public ShipServiceImpl(ShipRepository shipRepository, CurrentUser currentUser, AddShipMapper addShipMapper, CategoryService categoryService, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.currentUser = currentUser;
        this.addShipMapper = addShipMapper;
        this.categoryService = categoryService;
        this.userRepository = userRepository;
    }

    @Override
    public List<Ship> userShips() {
        return this.shipRepository.findByUserId(currentUser.getId()).orElse(new ArrayList<>());
    }

    @Override
    public List<Ship> allOtherShipsExceptCurrentUserShip() {
        return this.shipRepository.findDistinctByUser_IdNotLike(currentUser.getId()).orElse(new ArrayList<>());
    }

    @Override
    public List<Ship> allShips() {
        return this.shipRepository.findAll();
    }


    @Override
    public void addShip(AddShipDto addShipDto) {
        Ship ship = addShipMapper.addShipDtoToShipEntity(addShipDto);
        ship.setCategory(categoryService.getCategory(addShipDto.getCategoryId()));
        ship.setUser(userRepository.findById(currentUser.getId()).get());
        this.shipRepository.save(ship);
    }


}
