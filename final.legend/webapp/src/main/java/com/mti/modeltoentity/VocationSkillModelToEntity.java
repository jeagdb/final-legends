package com.mti.modeltoentity;

import com.mti.domain.entity.VocationSkillEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.VocationSkillModel;
import utils.Converter;

@ConvertService
public class VocationSkillModelToEntity implements Converter.Reversible<VocationSkillModel, VocationSkillEntity> {
    public final VocationModelToEntity vocationModelToEntity;
    public final SkillModelToEntity skillModelToEntity;

    public VocationSkillModelToEntity(VocationModelToEntity vocationModelToEntity, SkillModelToEntity skillModelToEntity) {
        this.vocationModelToEntity = vocationModelToEntity;
        this.skillModelToEntity = skillModelToEntity;
    }

    @Override
    public VocationSkillEntity convert(VocationSkillModel from) {
        return new VocationSkillEntity(vocationModelToEntity.convert(from.getVocationModel()),
                skillModelToEntity.convert(from.getSkillModel()));
    }

    @Override
    public VocationSkillModel revertConvert(VocationSkillEntity from) {
        return new VocationSkillModel(vocationModelToEntity.revertConvert(from.vocationEntity),
                skillModelToEntity.revertConvert(from.skillEntity));
    }
}
