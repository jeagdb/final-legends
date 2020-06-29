package com.mti.modeltoentity;

import com.mti.domain.entity.MonsterEntity;

import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.MonsterModel;
import utils.Converter;

@ConvertService
public class MonsterModelToEntity implements Converter.Reversible<MonsterModel, MonsterEntity> {

    private final StatModelToEntity statModelToEntity;

    public MonsterModelToEntity(StatModelToEntity statModelToEntity) {
        this.statModelToEntity = statModelToEntity;
    }

    @Override
    public MonsterEntity convert(MonsterModel from) {
        return new MonsterEntity(from.getId(), from.getName(), from.getXp(), statModelToEntity.convert(from.getStatModel()));
    }

    @Override
    public MonsterModel revertConvert(MonsterEntity from) {
        return new MonsterModel(from.id, from.name, from.xp, statModelToEntity.revertConvert(from.stat));
    }
}
