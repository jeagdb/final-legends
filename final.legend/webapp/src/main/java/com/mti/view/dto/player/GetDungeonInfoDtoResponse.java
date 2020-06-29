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
        public final String name;

        public MonsterDtoResponse(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
