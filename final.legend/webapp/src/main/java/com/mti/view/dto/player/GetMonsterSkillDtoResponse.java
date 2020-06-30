package com.mti.view.dto.player;

public class GetMonsterSkillDtoResponse {
    public final Iterable<GetMonsterSkillDtoResponse.MonsterSkillDtoResponse> allMonsterSkills;

    public GetMonsterSkillDtoResponse(Iterable<GetMonsterSkillDtoResponse.MonsterSkillDtoResponse> allMonsterSkills) {
        this.allMonsterSkills = allMonsterSkills;
    }

    public static class MonsterSkillDtoResponse {
        public final GetMonsterSkillDtoResponse.MonsterDtoResponse monsterDtoResponse;
        public final GetMonsterSkillDtoResponse.SkillDtoResponse skillDtoResponse;

        public MonsterSkillDtoResponse(GetMonsterSkillDtoResponse.MonsterDtoResponse monsterDtoResponse, GetMonsterSkillDtoResponse.SkillDtoResponse skillDtoResponse) {
            this.monsterDtoResponse = monsterDtoResponse;
            this.skillDtoResponse = skillDtoResponse;
        }
    }

    public static class MonsterDtoResponse {
        public final String name;
        public final Integer xp;

        public MonsterDtoResponse(String name, Integer xp) {
            this.name = name;
            this.xp = xp;
        }
    }

    public static class SkillDtoResponse {
        public final Integer id;
        public final String Name;
        public final Integer damage;
        public final Integer cost;

        public SkillDtoResponse(Integer id, String name, Integer damage, Integer cost) {
            this.id = id;
            Name = name;
            this.damage = damage;
            this.cost = cost;
        }
    }
}
