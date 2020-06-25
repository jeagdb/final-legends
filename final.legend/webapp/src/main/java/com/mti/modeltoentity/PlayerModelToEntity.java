package com.mti.modeltoentity;

import com.mti.domain.entity.PlayerEntity;
import com.mti.domain.entity.StatEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.PlayerModel;
import com.mti.persistence.model.StatModel;
import utils.Converter;

@ConvertService
public class PlayerModelToEntity implements Converter<PlayerModel, PlayerEntity> {

    private final ClassModelToEntity classModelToEntity;
    private final StatModelToEntity statModelToEntity;

    public PlayerModelToEntity(ClassModelToEntity classModelToEntity, StatModelToEntity statModelToEntity) {
        this.classModelToEntity = classModelToEntity;
        this.statModelToEntity = statModelToEntity;
    }

    @Override
    public PlayerEntity convert(PlayerModel from) {
        return new PlayerEntity(from.getId(),
                from.getName(),
                from.getLevel(),
                classModelToEntity.convert(from.getClassModel()),
                statModelToEntity.convert(from.getStatModel()),
                from.getExperience());
    }
}