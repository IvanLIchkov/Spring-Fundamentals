package com.exam.battleships.models.dtos;

import jakarta.validation.constraints.NotNull;

public class ShipsFightDto {

    @NotNull
    private Long attackShipId;

    @NotNull
    private Long defenderShipId;

    public Long getAttackShipId() {
        return attackShipId;
    }

    public void setAttackShipId(Long attackShipId) {
        this.attackShipId = attackShipId;
    }

    public Long getDefenderShipId() {
        return defenderShipId;
    }

    public void setDefenderShipId(Long defenderShipId) {
        this.defenderShipId = defenderShipId;
    }
}
