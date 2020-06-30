package com.mti.domain.service;

import com.mti.domain.entity.DungeonEntity;
import com.mti.domain.entity.DungeonInfoEntity;
import com.mti.domain.entity.MonsterEntity;
import com.mti.modeltoentity.DungeonModelToEntity;
import com.mti.modeltoentity.MonsterModelToEntity;
import com.mti.persistence.model.DungeonModel;
import com.mti.persistence.model.MonsterModel;
import com.mti.persistence.repository.DungeonRepository;
import com.mti.persistence.repository.MonsterRepository;
import org.springframework.stereotype.Service;
import utils.IterableUtils;
import utils.log.CanLog;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DungeonService implements CanLog {

    @Resource
    DungeonRepository dungeonRepository;

    @Resource
    DungeonModelToEntity dungeonModelToEntity;

    @Resource
    MonsterModelToEntity monsterModelToEntity;

    @Resource
    MonsterRepository monsterRepository;

    public DungeonService() {
    }

    public List<DungeonEntity> getAllDungeons() {
        final var allDungeons = IterableUtils.toList(dungeonRepository.findAll());
        return allDungeons.stream()
                .map(dungeonModel -> dungeonModelToEntity.convert(dungeonModel))
                .collect(Collectors.toList());
    }

    public DungeonInfoEntity getIntoDungeonById(Integer dungeonId) {
        final Optional<DungeonModel> dungeonModel = dungeonRepository.findById(dungeonId);
        if (dungeonModel.isEmpty()) {
            logger().warn("DungeonService.getIntoDungeonById: dungeonModel is empty");
        }
        DungeonEntity dungeonEntity = dungeonModelToEntity.convert(dungeonModel.get());
        final Iterable<MonsterModel> monsterModels = monsterRepository.findAll();
        List<MonsterEntity> monsterEntities = new ArrayList<>();
        monsterModels.forEach(monsterModel -> {
            monsterEntities.add(monsterModelToEntity.convert(monsterModel));
        });
        DungeonInfoEntity dungeonInfoEntity = new DungeonInfoEntity(dungeonEntity.name, monsterEntities);
        return dungeonInfoEntity;
    }
}
