package com.mti.modeltoentity;

import com.mti.domain.entity.StatEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.StatModel;
import utils.Converter;

@ConvertService
public class StatModelToEntity implements Converter.Reversible<StatModel, StatEntity>{
    @Override
    public StatEntity convert(StatModel from) {
        return new StatEntity(from.getId(),
                from.getHealth(),
                from.getMana(),
                from.getAttack(),
                from.getDefense(),
                from.getIntelligence(),
                from.getAgility());
    }

    @Override
    public StatModel revertConvert(StatEntity from) {
        return new StatModel(from.id,
                from.health,
                from.mana,
                from.attack,
                from.defense,
                from.intelligence,
                from.agility);
    }
}
