package com.mti.domain.entity;

import com.mti.persistence.model.ClassModel;

public class PlayerEntity {
    public final Integer id;
    public final String name;
    public final Integer level;
    public final ClassEntity classEntity;
    public final StatEntity statEntity;
    public final Integer experience;

    public PlayerEntity(Integer id, String name, Integer level, ClassEntity classEntity, StatEntity statEntity, Integer experience) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.classEntity = classEntity;
        this.statEntity = statEntity;
        this.experience = experience;
    }
}
