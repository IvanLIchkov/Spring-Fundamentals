package com.exam.battleships.service;

import com.exam.battleships.models.dtos.AddShipDto;
import com.exam.battleships.models.entities.Ship;

import java.util.List;

public interface ShipService {

     List<Ship> userShips();

     List<Ship> allOtherShipsExceptCurrentUserShip();

     List<Ship> allShips();

     void addShip(AddShipDto addShipDto);
}
