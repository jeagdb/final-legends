package com.mti.legend.domain.modeltoentity;

import com.mti.legend.domain.entity.StatEntity;
import com.mti.legend.utils.scope.ConvertService;
import com.mti.legend.persistence.model.StatModel;
import com.mti.legend.utils.Converter;

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
