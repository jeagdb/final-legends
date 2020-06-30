package com.mti.view.controller;

import com.mti.domain.entity.DungeonEntity;
import com.mti.domain.entity.DungeonInfoEntity;
import com.mti.domain.entity.SkillEntity;
import com.mti.domain.service.DungeonService;
import com.mti.domain.service.MonsterService;
import com.mti.domain.service.MonsterSkillService;
import com.mti.domain.service.PlayerService;
import com.mti.dtotoentity.GetDungeonInfoDtoResponseToEntity;
import com.mti.view.dto.player.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dungeons")
public class DungeonController {

    @Resource
    public DungeonService dungeonService;

    @Resource
    public PlayerService playerService;

    @Resource
    public MonsterSkillService monsterSkillService;

    @Resource
    public GetDungeonInfoDtoResponseToEntity getDungeonInfoDtoResponseToEntity;

    public DungeonController() {
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

    @PutMapping(path = "/")
    public AttackDungeonDtoResponse attackDungeonMonster(final @RequestBody AttackDungeonDtoRequest attackDungeonDtoRequest) {
        SkillEntity playerSkillEntity = playerService.getDamagesPlayerSkill(attackDungeonDtoRequest.skillId);
        SkillEntity monsterSkillEntity = monsterSkillService.getDamagesMonsterSkill(attackDungeonDtoRequest.monsterId);
        AttackDungeonDtoResponse.AttackMonsterDtoResponse attackMonsterDtoResponse =
                new AttackDungeonDtoResponse.AttackMonsterDtoResponse(monsterSkillEntity.name, monsterSkillEntity.damage);
        AttackDungeonDtoResponse.AttackPlayerDtoResponse attackPlayerDtoResponse =
                new AttackDungeonDtoResponse.AttackPlayerDtoResponse(playerSkillEntity.name, playerSkillEntity.damage, playerSkillEntity.cost);
        return new AttackDungeonDtoResponse(attackPlayerDtoResponse, attackMonsterDtoResponse);
    }
}
