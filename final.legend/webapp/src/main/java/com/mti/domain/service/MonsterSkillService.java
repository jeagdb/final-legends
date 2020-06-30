package com.mti.domain.service;

import com.mti.domain.entity.MonsterSkillEntity;
import com.mti.modeltoentity.MonsterSkillModelToEntity;
import com.mti.persistence.repository.MonsterSkillRepository;
import org.springframework.stereotype.Service;
import utils.IterableUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterSkillService {

    private MonsterSkillRepository monsterSkillRepository;
    public MonsterSkillModelToEntity monsterSkillModelToEntity;

    public MonsterSkillService(MonsterSkillRepository monsterSkillRepository, MonsterSkillModelToEntity monsterSkillModelToEntity) {
        this.monsterSkillRepository = monsterSkillRepository;
        this.monsterSkillModelToEntity = monsterSkillModelToEntity;
    }

    public List<MonsterSkillEntity> findAllMonsterSkills() {
        final var allMonsterSkills = IterableUtils.toList(monsterSkillRepository.findAll());
        return allMonsterSkills.stream()
                .map(monsterSkillModel -> monsterSkillModelToEntity.convert(monsterSkillModel))
                .collect(Collectors.toList());
    }
}
