package com.mti.dtotoentity;

import com.mti.domain.entity.SkillEntity;
import com.mti.domain.entity.VocationSkillEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.view.dto.player.GetMonsterSkillDtoResponse;
import com.mti.view.dto.player.GetPlayerSkillsDtoResponse;
import com.mti.view.dto.player.GetVocationSkillDtoResponse;
import utils.Converter;

import java.util.List;
import java.util.stream.Collectors;

@ConvertService
public class GetPlayerSkillsDtoResponseToEntity implements Converter.Reversible<GetPlayerSkillsDtoResponse, List<SkillEntity>> {
    @Override
    public List<SkillEntity> convert(GetPlayerSkillsDtoResponse from) {
        return null;
    }

    @Override
    public GetPlayerSkillsDtoResponse revertConvert(List<SkillEntity> from) {
        return new GetPlayerSkillsDtoResponse(from.stream().map(skillEntity -> {
            var skillDtoResponse = new GetPlayerSkillsDtoResponse.SkillDtoResponse(
                    skillEntity.name,
                    skillEntity.cost,
                    skillEntity.damage
            );
            return skillDtoResponse;
        }).collect(Collectors.toList()));
    }
}
