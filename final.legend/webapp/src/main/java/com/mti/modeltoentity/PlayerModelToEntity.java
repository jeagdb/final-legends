package com.mti.modeltoentity;

import com.mti.domain.entity.PlayerEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.PlayerModel;
import utils.Converter;

@ConvertService
public class PlayerModelToEntity implements Converter.Reversible<PlayerModel, PlayerEntity> {

    private final VocationModelToEntity vocationModelToEntity;
    private final StatModelToEntity statModelToEntity;

    public PlayerModelToEntity(VocationModelToEntity vocationModelToEntity, StatModelToEntity statModelToEntity) {
        this.vocationModelToEntity = vocationModelToEntity;
        this.statModelToEntity = statModelToEntity;
    }

    @Override
    public PlayerEntity convert(PlayerModel from) {
        return new PlayerEntity(from.getId(),
                from.getName(),
                from.getLevel(),
                vocationModelToEntity.convert(from.getVocationModel()),
                statModelToEntity.convert(from.getStatModel()),
                from.getExperience());
    }

    @Override
    public PlayerModel revertConvert(PlayerEntity from) {
        return new PlayerModel(from.id,
                from.name,
                from.level,
                vocationModelToEntity.revertConvert(from.vocationEntity),
                statModelToEntity.revertConvert(from.statEntity),
                from.experience);
    }
}