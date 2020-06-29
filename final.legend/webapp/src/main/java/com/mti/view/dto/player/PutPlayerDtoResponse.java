package com.mti.view.dto.player;

public class PutPlayerDtoResponse {
    public final Integer id;
    public final String name;
    public final Integer level;
    public final VocationDtoResponse vocationId;
    public final StatDtoResponse statId;
    public final Integer experience;

    public PutPlayerDtoResponse(Integer id, String name, Integer level, VocationDtoResponse vocationId, StatDtoResponse statId, Integer experience) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.vocationId = vocationId;
        this.statId = statId;
        this.experience = experience;
    }

    public static class VocationDtoResponse {
        public final Integer id;
        public final String name;

        public VocationDtoResponse(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class StatDtoResponse {
        public final Integer id;
        public final Integer health;
        public final Integer mana;
        public final Integer attack;
        public final Integer defense;
        public final Integer intelligence;
        public final Integer agility;

        public StatDtoResponse(Integer id, Integer health, Integer mana, Integer attack, Integer defense, Integer intelligence, Integer agility) {
            this.id = id;
            this.health = health;
            this.mana = mana;
            this.attack = attack;
            this.defense = defense;
            this.intelligence = intelligence;
            this.agility = agility;
        }
    }
}
