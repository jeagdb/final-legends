package com.mti.view.dto.player;

public class GetPlayersDtoResponse {
    public final Iterable<PlayerDtoResponse> allPlayers;

    public GetPlayersDtoResponse(Iterable<PlayerDtoResponse> allPlayers) {
        this.allPlayers = allPlayers;
    }

    public static class PlayerDtoResponse {
        public final String name;
        public final Integer level;
        public final VocationDtoResponse vocation;
        public final StatDtoResponse stat;
        public final Integer experience;

        public PlayerDtoResponse(String name, Integer level, VocationDtoResponse vocation, StatDtoResponse stat, Integer experience) {
            this.name = name;
            this.level = level;
            this.vocation = vocation;
            this.stat = stat;
            this.experience = experience;
        }
    }

    public static class VocationDtoResponse {
        public final String name;

        public VocationDtoResponse(String name) {
            this.name = name;
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
