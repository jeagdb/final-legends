package com.mti.domain.entity;

public class MonsterEntity {
    public final Integer id;
    public final String name;
    public final Integer xp;
    public final StatEntity stat;

    public MonsterEntity(Integer id, String name, Integer xp, StatEntity stat) {
        this.id = id;
        this.name = name;
        this.xp = xp;
        this.stat = stat;
    }
}
