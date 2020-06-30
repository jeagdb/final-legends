package com.mti.modeltoentity;

import com.mti.domain.entity.MonsterSkillEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.MonsterSkillModel;
import utils.Converter;

@ConvertService
public class MonsterSkillModelToEntity implements Converter.Reversible<MonsterSkillModel, MonsterSkillEntity> {
    public final MonsterModelToEntity monsterModelToEntity;
    public final SkillModelToEntity skillModelToEntity;

    public MonsterSkillModelToEntity(MonsterModelToEntity monsterModelToEntity, SkillModelToEntity skillModelToEntity) {
        this.monsterModelToEntity = monsterModelToEntity;
        this.skillModelToEntity = skillModelToEntity;
    }

    @Override
    public MonsterSkillEntity convert(MonsterSkillModel from) {
        return new MonsterSkillEntity(monsterModelToEntity.convert(from.getMonsterModel()),
                skillModelToEntity.convert(from.getSkillModel()));
    }

    @Override
    public MonsterSkillModel revertConvert(MonsterSkillEntity from) {
        return new MonsterSkillModel(monsterModelToEntity.revertConvert(from.monsterEntity),
                skillModelToEntity.revertConvert(from.skillEntity));
    }
}
