package com.mti.legend.domain.service;

import com.mti.legend.domain.entity.PlayerEntity;
import com.mti.legend.domain.modeltoentity.PlayerModelToEntity;
import com.mti.legend.persistence.model.PlayerModel;
import com.mti.legend.persistence.repository.PlayerRepository;
import com.mti.legend.utils.IterableUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
