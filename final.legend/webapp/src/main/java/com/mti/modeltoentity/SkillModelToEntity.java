package com.mti.modeltoentity;

import com.mti.domain.entity.SkillEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.SkillModel;
import utils.Converter;

@ConvertService
public class SkillModelToEntity implements Converter.Reversible<SkillModel, SkillEntity> {
    @Override
    public SkillEntity convert(SkillModel from) {
        return new SkillEntity(from.getId(), from.getName(), from.getDamage(), from.getCost());
    }

    @Override
    public SkillModel revertConvert(SkillEntity from) {
        return new SkillModel(from.id, from.name, from.damage, from.cost);
    }
}
