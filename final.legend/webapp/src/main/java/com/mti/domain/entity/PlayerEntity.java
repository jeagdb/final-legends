package com.mti.domain.entity;

public class PlayerEntity {
    public final Integer id;
    public final String name;
    public final Integer level;
    public final VocationEntity vocationEntity;
    public final StatEntity statEntity;
    public final Integer experience;

    public PlayerEntity(Integer id, String name, Integer level, VocationEntity vocationEntity, StatEntity statEntity, Integer experience) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.vocationEntity = vocationEntity;
        this.statEntity = statEntity;
        this.experience = experience;
    }
}
