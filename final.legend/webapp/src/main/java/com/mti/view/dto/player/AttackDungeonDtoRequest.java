package com.mti.view.dto.player;

public class AttackDungeonDtoRequest {
    public final Integer skillId;
    public final Integer monsterId;

    public AttackDungeonDtoRequest(Integer skillId, Integer monsterId) {
        this.skillId = skillId;
        this.monsterId = monsterId;
    }
}
