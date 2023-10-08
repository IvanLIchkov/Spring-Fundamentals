package com.exam.battleships.service.impl;

import com.exam.battleships.models.entities.Ship;
import com.exam.battleships.repositories.ShipRepository;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final ShipRepository shipRepository;

    public HomeService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    public void fire(Long attackerId, Long defenderId){
        Ship attackerShip = this.shipRepository.findById(attackerId).get();
        Ship deffenderShip = this.shipRepository.findById(defenderId).get();

        if (deffenderShip.getHealth()<=attackerShip.getPower()){
            this.shipRepository.deleteById(defenderId);
        }else{
            deffenderShip.setHealth(deffenderShip.getHealth()-attackerShip.getPower());
            this.shipRepository.save(deffenderShip);
        }
    }
}
