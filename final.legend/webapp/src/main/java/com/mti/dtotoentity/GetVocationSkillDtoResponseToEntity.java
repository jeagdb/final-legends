package com.mti.dtotoentity;

import com.mti.domain.entity.VocationSkillEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.view.dto.player.GetVocationSkillDtoResponse;
import utils.Converter;

import java.util.List;
import java.util.stream.Collectors;

@ConvertService
public class GetVocationSkillDtoResponseToEntity implements Converter.Reversible<GetVocationSkillDtoResponse, List<VocationSkillEntity>> {
    @Override
    public List<VocationSkillEntity> convert(GetVocationSkillDtoResponse from) {
        return null;
    }

    @Override
    public GetVocationSkillDtoResponse revertConvert(List<VocationSkillEntity> from) {
        return new GetVocationSkillDtoResponse(from.stream().map(vocationSkillEntity -> {
            var vocationDtoResponse = new GetVocationSkillDtoResponse.VocationDtoResponse(vocationSkillEntity.vocationEntity.name);
            var skillDtoResponse = new GetVocationSkillDtoResponse.SkillDtoResponse(vocationSkillEntity.skillEntity.id,
                    vocationSkillEntity.skillEntity.name,
                    vocationSkillEntity.skillEntity.damage,
                    vocationSkillEntity.skillEntity.cost);
            return new GetVocationSkillDtoResponse.VocationSkillDtoResponse(vocationDtoResponse, skillDtoResponse);
        }).collect(Collectors.toList()));
    }
}
