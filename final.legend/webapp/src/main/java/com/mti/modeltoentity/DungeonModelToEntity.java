package com.mti.modeltoentity;

import com.mti.domain.entity.DungeonEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.DungeonModel;
import utils.Converter;

@ConvertService
public class DungeonModelToEntity implements Converter.Reversible<DungeonModel, DungeonEntity> {
    @Override
    public DungeonEntity convert(DungeonModel from) {
        return new DungeonEntity(from.getId(), from.getName());
    }

    @Override
    public DungeonModel revertConvert(DungeonEntity from) {
        return null;
    }
}
