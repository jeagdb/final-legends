package com.mti.domain.service;

import com.mti.domain.entity.DungeonEntity;
import com.mti.modeltoentity.DungeonModelToEntity;
import com.mti.persistence.repository.DungeonRepository;
import org.springframework.stereotype.Service;
import utils.IterableUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DungeonService {

    private DungeonRepository dungeonRepository;
    public DungeonModelToEntity dungeonModelToEntity;

    public DungeonService(final DungeonRepository dungeonRepository, final DungeonModelToEntity dungeonModelToEntity) {
        this.dungeonRepository = dungeonRepository;
        this.dungeonModelToEntity = dungeonModelToEntity;
    }

    public List<DungeonEntity> getAllDungeons() {
        final var allDungeons = IterableUtils.toList(dungeonRepository.findAll());
        return allDungeons.stream()
                .map(dungeonModel -> dungeonModelToEntity.convert(dungeonModel))
                .collect(Collectors.toList());
    }
}
