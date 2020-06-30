package com.mti.domain.entity;

public class SkillEntity {
    public final Integer id;
    public final String name;
    public final Integer damage;
    public final Integer cost;

    public SkillEntity(Integer id, String name, Integer damage, Integer cost) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.cost = cost;
    }
}
