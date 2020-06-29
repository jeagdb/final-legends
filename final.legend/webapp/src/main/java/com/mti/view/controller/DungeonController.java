package com.mti.view.controller;

import com.mti.domain.entity.DungeonEntity;
import com.mti.domain.service.DungeonService;
import com.mti.view.dto.player.AttackDungeonDtoRequest;
import com.mti.view.dto.player.GetAllDungeonsDtoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dungeons")
public class DungeonController {

    private final DungeonService dungeonService;

    public DungeonController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;
    }

    @GetMapping("/")
    public GetAllDungeonsDtoResponse getAllDungeons() {
        // return the name of the available dungeons
        List<DungeonEntity> dungeons = dungeonService.getAllDungeons();
        return new GetAllDungeonsDtoResponse(dungeons.stream().map(dungeonEntity -> { return new GetAllDungeonsDtoResponse.DungeonDtoResponse(dungeonEntity.id, dungeonEntity.name);}).collect(Collectors.toList()));
    }

    @GetMapping(path = "{id}")
    public void getDungeon(@PathVariable("id") int dungeonId) {
        // get into dungeon {id} - return enemy to defeat with infos
    }

    @PutMapping(path = "{id}")
    public void attackDungeon(@PathVariable("id") int dungeonId, final @RequestBody AttackDungeonDtoRequest attackDungeonDtoRequest) {
        String skill = attackDungeonDtoRequest.skill;
        // check mana
    }
}
