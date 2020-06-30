package com.mti.view.controller;

import com.mti.domain.entity.MonsterSkillEntity;
import com.mti.domain.entity.VocationSkillEntity;
import com.mti.domain.service.MonsterSkillService;
import com.mti.domain.service.VocationSkillService;
import com.mti.dtotoentity.GetMonsterSkillDtoResponseToEntity;
import com.mti.dtotoentity.GetVocationSkillDtoResponseToEntity;
import com.mti.view.dto.player.GetMonsterSkillDtoResponse;
import com.mti.view.dto.player.GetVocationSkillDtoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    private final VocationSkillService vocationSkillService;
    private final MonsterSkillService monsterSkillService;

    @Resource
    GetVocationSkillDtoResponseToEntity getVocationSkillDtoResponseToEntity;

    @Resource
    GetMonsterSkillDtoResponseToEntity getMonsterSkillDtoResponseToEntity;

    public SkillController(VocationSkillService vocationSkillService, MonsterSkillService monsterSkillService) {
        this.vocationSkillService = vocationSkillService;
        this.monsterSkillService = monsterSkillService;
    }

    @GetMapping("/vocation")
    public GetVocationSkillDtoResponse getVocationSkills() {
        List<VocationSkillEntity> vocationSkillEntities = vocationSkillService.findAllVocationSkills();
        return getVocationSkillDtoResponseToEntity.revertConvert(vocationSkillEntities);
    }

    @GetMapping("/monster")
    public GetMonsterSkillDtoResponse getMonsterSkills() {
        List<MonsterSkillEntity> monsterSkillEntities = monsterSkillService.findAllMonsterSkills();
        return getMonsterSkillDtoResponseToEntity.revertConvert(monsterSkillEntities);
    }
}
