package com.mti.legendsdb.view.playercontroller;

public class PutPlayerDtoRequest {
    public final Integer id;
    public final String name;
    public final Integer level;
    public final VocationDtoRequest vocationId;
    public final StatDtoRequest statId;
    public final Integer experience;

    public PutPlayerDtoRequest(Integer id, String name, Integer level, VocationDtoRequest vocationId, StatDtoRequest statId, Integer experience) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.vocationId = vocationId;
        this.statId = statId;
        this.experience = experience;
    }

    public static class VocationDtoRequest {
        public final Integer id;
        public final String name;

        public VocationDtoRequest(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class StatDtoRequest {
        public final Integer id;
        public final Integer health;
        public final Integer mana;
        public final Integer attack;
        public final Integer defense;
        public final Integer intelligence;
        public final Integer agility;

        public StatDtoRequest(Integer id, Integer health, Integer mana, Integer attack, Integer defense, Integer intelligence, Integer agility) {
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
