package com.mti.legendsdb.view.playercontroller;

public class GetPlayersDtoResponse {
    public final Iterable<PlayerDtoResponse> allPlayers;

    public GetPlayersDtoResponse(Iterable<PlayerDtoResponse> allPlayers) {
        this.allPlayers = allPlayers;
    }

    public static class PlayerDtoResponse {
        public final Integer id;
        public final String name;
        public final Integer level;
        public final ClassDtoResponse classId;
        public final StatDtoResponse statId;
        public final Integer experience;

        public PlayerDtoResponse(Integer id, String name, Integer level, ClassDtoResponse classId, StatDtoResponse statId, Integer experience) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.classId = classId;
            this.statId = statId;
            this.experience = experience;
        }
    }

    public static class ClassDtoResponse {
        public final Integer id;
        public final String name;

        public ClassDtoResponse(Integer id, String name) {
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
