package com.mti.view.dto.player;

import java.util.List;

public class GetAllDungeonsDtoResponse {
    public final List<DungeonDtoResponse> dungeons;

    public GetAllDungeonsDtoResponse(List<DungeonDtoResponse> dungeons) {
        this.dungeons = dungeons;
    }
    public static class DungeonDtoResponse {
        public final Integer id;
        public final String name;
        public DungeonDtoResponse(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
