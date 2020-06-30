package com.mti.domain.entity;

public class MonsterSkillEntity {
    public final MonsterEntity monsterEntity;
    public final SkillEntity skillEntity;

    public MonsterSkillEntity(MonsterEntity monsterEntity, SkillEntity skillEntity) {
        this.monsterEntity = monsterEntity;
        this.skillEntity = skillEntity;
    }
}
