package com.mti.domain.service;

import com.mti.domain.entity.StatEntity;
import com.mti.modeltoentity.PlayerModelToEntity;
import com.mti.modeltoentity.StatModelToEntity;
import com.mti.persistence.model.StatModel;
import com.mti.persistence.repository.StatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatService {
    private StatRepository statRepository;
    public StatModelToEntity statModelToEntity;
    public StatService(final StatRepository statRepository, final StatModelToEntity statModelToEntity) {
        this.statRepository = statRepository;
        this.statModelToEntity = statModelToEntity;
    }

    @Transactional
    public StatEntity generatePlayerStatsWithVocation(Integer vocationId) {
        StatModel statModel = new StatModel();
        // random /!\
        statModel.setHealth(5);
        statModel.setMana(5);
        statModel.setAttack(5);
        statModel.setDefense(5);
        statModel.setIntelligence(5);
        statModel.setAgility(5);
        final var resultModel = statRepository.save(statModel);
        // need to check the resultModel if save fail
        return statModelToEntity.convert(resultModel);
    }
}
