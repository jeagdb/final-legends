package com.mti.view.dto.player;

public class AttackDungeonDtoResponse {

    public final Integer damagesPlayer;
    public final Integer damagesMonster;

    public Integer getDamagesPlayer() {
        return damagesPlayer;
    }

    public Integer getDamagesMonster() {
        return damagesMonster;
    }

    public AttackDungeonDtoResponse(Integer damagesPlayer, Integer damagesMonster) {
        this.damagesPlayer = damagesPlayer;
        this.damagesMonster = damagesMonster;
    }
}
