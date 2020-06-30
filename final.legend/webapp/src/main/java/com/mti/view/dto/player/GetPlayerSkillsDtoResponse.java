package com.mti.view.dto.player;

import java.util.List;

public class GetPlayerSkillsDtoResponse {
    public final Iterable<SkillDtoResponse> skills;

    public GetPlayerSkillsDtoResponse(List<SkillDtoResponse> skills) {
        this.skills = skills;
    }

    public static class SkillDtoResponse {
        public final String name;
        public final Integer damage;
        public final Integer cost;

        public SkillDtoResponse(String name, Integer damage, Integer cost) {
            this.name = name;
            this.damage = damage;
            this.cost = cost;
        }
    }
}
