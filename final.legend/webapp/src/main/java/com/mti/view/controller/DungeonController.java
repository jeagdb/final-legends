package com.mti.view.controller;

import com.mti.domain.entity.DungeonEntity;
import com.mti.domain.entity.DungeonInfoEntity;
import com.mti.domain.service.DungeonService;
import com.mti.dtotoentity.GetDungeonInfoDtoResponseToEntity;
import com.mti.view.dto.player.AttackDungeonDtoRequest;
import com.mti.view.dto.player.GetAllDungeonsDtoResponse;
import com.mti.view.dto.player.GetDungeonInfoDtoResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dungeons")
public class DungeonController {

    private final DungeonService dungeonService;

    @Resource
    public GetDungeonInfoDtoResponseToEntity getDungeonInfoDtoResponseToEntity;

    public DungeonController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;
    }

    @GetMapping("/")
    public GetAllDungeonsDtoResponse getAllDungeons() {
        List<DungeonEntity> dungeons = dungeonService.getAllDungeons();
        return new GetAllDungeonsDtoResponse(dungeons.stream().map(dungeonEntity -> { return new GetAllDungeonsDtoResponse.DungeonDtoResponse(dungeonEntity.id, dungeonEntity.name);}).collect(Collectors.toList()));
    }

    @GetMapping(path = "{id}")
    public GetDungeonInfoDtoResponse getDungeon(@PathVariable("id") int dungeonId) {
        DungeonInfoEntity dungeonInfoEntities = dungeonService.getIntoDungeonById(dungeonId);
        return getDungeonInfoDtoResponseToEntity.revertConvert(dungeonInfoEntities);
    }

    @PutMapping(path = "{id}")
    public void attackDungeon(@PathVariable("id") int dungeonId, final @RequestBody AttackDungeonDtoRequest attackDungeonDtoRequest) {
        String skill = attackDungeonDtoRequest.skill;
        // check mana
    }
}
