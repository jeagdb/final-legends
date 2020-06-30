package com.mti.domain.service;

import com.mti.domain.entity.PlayerEntity;
import com.mti.modeltoentity.PlayerModelToEntity;
import com.mti.persistence.model.PlayerModel;
import com.mti.persistence.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.IterableUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    public PlayerModelToEntity playerModelToEntity;

    public PlayerService(final PlayerRepository playerRepository, final PlayerModelToEntity playerModelToEntity) {
        this.playerRepository = playerRepository;
        this.playerModelToEntity = playerModelToEntity;
    }

    public Integer getDamagesPlayerSkill(Integer skillId) {
        // skill reposition
        return 10;
    }

    public List<PlayerEntity> findAllPlayers() {
        final var allPlayerModel = IterableUtils.toList(playerRepository.findAll());
        return allPlayerModel.stream()
                .map(playerModel -> playerModelToEntity.convert(playerModel))
                .collect(Collectors.toList());
    }

    @Transactional
    public PlayerEntity save(final PlayerEntity playerEntity) {
        final PlayerModel playerModel = playerModelToEntity.revertConvert(playerEntity);
        final var resultModel = playerRepository.save(playerModel);
        return playerModelToEntity.convert(resultModel);
    }
}
