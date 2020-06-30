package com.mti.view.dto.player;

public class AttackDungeonDtoResponse {

    private final AttackPlayerDtoResponse player;
    private final AttackMonsterDtoResponse monster;

    public AttackDungeonDtoResponse(AttackPlayerDtoResponse player, AttackMonsterDtoResponse monster) {
        this.player = player;
        this.monster = monster;
    }

    public AttackPlayerDtoResponse getPlayer() {
        return player;
    }

    public AttackMonsterDtoResponse getMonster() {
        return monster;
    }

    public static class AttackPlayerDtoResponse {
        private final String skillPlayer;
        private final Integer damagesPlayer;
        private final Integer costPlayer;

        public AttackPlayerDtoResponse(String skillPlayer, Integer damagesPlayer, Integer costPlayer) {
            this.skillPlayer = skillPlayer;
            this.damagesPlayer = damagesPlayer;
            this.costPlayer = costPlayer;
        }

        public String getSkillPlayer() {
            return skillPlayer;
        }

        public Integer getDamagesPlayer() {
            return damagesPlayer;
        }

        public Integer getCostPlayer() {
            return costPlayer;
        }
    }

    public static class AttackMonsterDtoResponse {
        private final String skillMonster;
        private final Integer damagesMonster;

        public AttackMonsterDtoResponse(String skillMonster, Integer damagesMonster) {
            this.skillMonster = skillMonster;
            this.damagesMonster = damagesMonster;
        }

        public String getSkillMonster() {
            return skillMonster;
        }

        public Integer getDamagesMonster() {
            return damagesMonster;
        }
    }
}
