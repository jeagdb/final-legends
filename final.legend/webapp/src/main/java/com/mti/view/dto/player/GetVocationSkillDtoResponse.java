package com.mti.view.dto.player;

public class GetVocationSkillDtoResponse {
    public final Iterable<GetVocationSkillDtoResponse.VocationSkillDtoResponse> allVocationSkills;

    public GetVocationSkillDtoResponse(Iterable<GetVocationSkillDtoResponse.VocationSkillDtoResponse> allVocationSkills) {
        this.allVocationSkills = allVocationSkills;
    }

    public static class VocationSkillDtoResponse {
        public final VocationDtoResponse vocationDtoResponse;
        public final SkillDtoResponse skillDtoResponse;

        public VocationSkillDtoResponse(VocationDtoResponse vocationDtoResponse, SkillDtoResponse skillDtoResponse) {
            this.vocationDtoResponse = vocationDtoResponse;
            this.skillDtoResponse = skillDtoResponse;
        }
    }

    public static class VocationDtoResponse {
        public final String name;

        public VocationDtoResponse(String name) {
            this.name = name;
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
