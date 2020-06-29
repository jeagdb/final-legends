package com.mti.domain.service;

import com.mti.domain.entity.StatEntity;
import com.mti.modeltoentity.StatModelToEntity;
import com.mti.persistence.model.StatModel;
import com.mti.persistence.repository.StatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.log.CanLog;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class StatService implements CanLog {
    private StatRepository statRepository;
    public StatModelToEntity statModelToEntity;
    public StatService(final StatRepository statRepository, final StatModelToEntity statModelToEntity) {
        this.statRepository = statRepository;
        this.statModelToEntity = statModelToEntity;
    }

    private Map<String, Integer> generateRandomStat(Integer vocationId) {
        Map<String, Integer> stats = new HashMap<>();
        Random random = new Random();
        if (vocationId == 1) {
            stats.put("health", random.nextInt((150 - 100) + 1) + 100);
            stats.put("mana", random.nextInt((400 - 300) + 1) + 300);
            stats.put("attack", random.nextInt((5 - 2) + 1) + 2);
            stats.put("defense", random.nextInt((4 - 2) + 1) + 2);
            stats.put("intelligence", random.nextInt((8 - 6) + 1) + 6);
            stats.put("agility", random.nextInt((6 - 3) + 1) + 3);
        } else if (vocationId == 2) {
            stats.put("health", random.nextInt((300 - 150) + 1) + 150);
            stats.put("mana", random.nextInt((300 - 200) + 1) + 200);
            stats.put("attack", random.nextInt((8 - 6) + 1) + 6);
            stats.put("defense", random.nextInt((6 - 3) + 1) + 3);
            stats.put("intelligence", random.nextInt((4 - 2) + 1) + 2);
            stats.put("agility", random.nextInt((5 - 2) + 1) + 2);
        } else if (vocationId == 3) {
            stats.put("health", random.nextInt((200 - 100) + 1) + 100);
            stats.put("mana", random.nextInt((300 - 200) + 1) + 200);
            stats.put("attack", random.nextInt((4 - 2) + 1) + 2);
            stats.put("defense", random.nextInt((5 - 2) + 1) + 2);
            stats.put("intelligence", random.nextInt((6 - 3) + 1) + 3);
            stats.put("agility", random.nextInt((8 - 6) + 1) + 6);
        }
        return stats;
    }

    @Transactional
    public StatEntity generatePlayerStatsWithVocation(Integer vocationId) {
        logger().info("StatService.generatePlayerStatsWithVocation: begin transaction");
        StatModel statModel = new StatModel();
        Map<String, Integer> stats = generateRandomStat(vocationId);
        statModel.setHealth(stats.get("health"));
        statModel.setMana(stats.get("mana"));
        statModel.setAttack(stats.get("attack"));
        statModel.setDefense(stats.get("defense"));
        statModel.setIntelligence(stats.get("intelligence"));
        statModel.setAgility(stats.get("agility"));
        final var resultModel = statRepository.save(statModel);
        // need to check the resultModel if save fail
        logger().info("StatService.generatePlayerStatsWithVocation: end transaction");
        return statModelToEntity.convert(resultModel);
    }
}
