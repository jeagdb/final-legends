package com.mti.domain.service;

import com.mti.domain.entity.PlayerEntity;
import com.mti.domain.entity.SkillEntity;
import com.mti.modeltoentity.PlayerModelToEntity;
import com.mti.modeltoentity.SkillModelToEntity;
import com.mti.persistence.model.PlayerModel;
import com.mti.persistence.model.SkillModel;
import com.mti.persistence.repository.PlayerRepository;
import com.mti.persistence.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.IterableUtils;
import utils.log.CanLog;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService implements CanLog{

    @Resource
    PlayerRepository playerRepository;

    @Resource
    SkillRepository skillRepository;

    @Resource
    public PlayerModelToEntity playerModelToEntity;

    public PlayerService() {
    }

    public SkillEntity getDamagesPlayerSkill(Integer skillId) {
        Optional<SkillModel> skillModel = skillRepository.findById(skillId);
        if (skillModel.isEmpty()) {
            logger().warn("PlayerService.getDamagesPlayerSkill: skillModel is empty.");
        }
        return new SkillModelToEntity().convert(skillModel.get());
    }

    public List<PlayerEntity> findAllPlayers() {
        final var allPlayerModel = IterableUtils.toList(playerRepository.findAll());
        return allPlayerModel.stream()
                .map(playerModel -> playerModelToEntity.convert(playerModel))
                .collect(Collectors.toList());
    }

    @Transactional
    public PlayerEntity save(final PlayerEntity playerEntity) {
        logger().info("PlayerService.save: starting transaction");
        final PlayerModel playerModel = playerModelToEntity.revertConvert(playerEntity);
        final var resultModel = playerRepository.save(playerModel);
        logger().info("PlayerService.save: ending transaction");
        return playerModelToEntity.convert(resultModel);
    }
}
