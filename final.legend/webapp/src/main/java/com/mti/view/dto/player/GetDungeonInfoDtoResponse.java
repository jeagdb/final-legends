package com.mti.view.dto.player;

import java.util.List;

public class GetDungeonInfoDtoResponse {
    public final String dungeon;
    public final List<MonsterDtoResponse> monsters;

    public GetDungeonInfoDtoResponse(String dungeon, List<MonsterDtoResponse> monsters) {
        this.dungeon = dungeon;
        this.monsters = monsters;
    }

    public static class MonsterDtoResponse {
        public final Integer id;
        public final StatDtoResponse stat;
        public final String name;
        public final Integer xp;

        public MonsterDtoResponse(Integer id, StatDtoResponse stat, String name, Integer xp) {
            this.id = id;
            this.stat = stat;
            this.name = name;
            this.xp = xp;
        }
    }

    public static class StatDtoResponse {
        public final Integer health;
        public final Integer mana;
        public final Integer attack;
        public final Integer defense;
        public final Integer intelligence;
        public final Integer agility;

        public StatDtoResponse(Integer health, Integer mana, Integer attack, Integer defense, Integer intelligence, Integer agility) {
            this.health = health;
            this.mana = mana;
            this.attack = attack;
            this.defense = defense;
            this.intelligence = intelligence;
            this.agility = agility;
        }
    }
}
