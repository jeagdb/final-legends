package com.mti.dtotoentity;

import com.mti.domain.entity.MonsterSkillEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.view.dto.player.GetMonsterSkillDtoResponse;
import utils.Converter;

import java.util.List;
import java.util.stream.Collectors;

@ConvertService
public class GetMonsterSkillDtoResponseToEntity implements Converter.Reversible<GetMonsterSkillDtoResponse, List<MonsterSkillEntity>>  {
    @Override
    public List<MonsterSkillEntity> convert(GetMonsterSkillDtoResponse from) {
        return null;
    }

    @Override
    public GetMonsterSkillDtoResponse revertConvert(List<MonsterSkillEntity> from) {
        return new GetMonsterSkillDtoResponse(from.stream().map(monsterSkillEntity -> {
            var monsterDtoResponse = new GetMonsterSkillDtoResponse.MonsterDtoResponse(monsterSkillEntity.monsterEntity.name,
                    monsterSkillEntity.monsterEntity.xp);
            var skillDtoResponse = new GetMonsterSkillDtoResponse.SkillDtoResponse(monsterSkillEntity.skillEntity.id,
                    monsterSkillEntity.skillEntity.name,
                    monsterSkillEntity.skillEntity.damage,
                    monsterSkillEntity.skillEntity.cost);
            return new GetMonsterSkillDtoResponse.MonsterSkillDtoResponse(monsterDtoResponse, skillDtoResponse);
        }).collect(Collectors.toList()));
    }
}
