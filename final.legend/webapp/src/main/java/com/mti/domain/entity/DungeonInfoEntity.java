package com.mti.domain.entity;

import java.util.List;

public class DungeonInfoEntity {
    final String dungeonName;
    final List<MonsterEntity> monsters;

    public String getDungeonName() {
        return dungeonName;
    }

    public List<MonsterEntity> getMonsters() {
        return monsters;
    }

    public DungeonInfoEntity(String dungeonName, List<MonsterEntity> monsters) {
        this.dungeonName = dungeonName;
        this.monsters = monsters;
    }
}
