package com.mti.dtotoentity;

import com.mti.domain.entity.DungeonEntity;
import com.mti.domain.entity.DungeonInfoEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.persistence.model.DungeonModel;
import com.mti.view.dto.player.GetDungeonInfoDtoResponse;
import utils.Converter;

import java.util.ArrayList;
import java.util.List;

@ConvertService
public class GetDungeonInfoDtoResponseToEntity implements Converter.Reversible<GetDungeonInfoDtoResponse, DungeonInfoEntity> {

    @Override
    public DungeonInfoEntity convert(GetDungeonInfoDtoResponse from) {
        return null;
    }

    @Override
    public GetDungeonInfoDtoResponse revertConvert(DungeonInfoEntity from) {
        List<GetDungeonInfoDtoResponse.MonsterDtoResponse> monsters = new ArrayList<>();
        from.getMonsters().stream().forEach(monster -> {
            GetDungeonInfoDtoResponse.MonsterDtoResponse newMonster =
                    new GetDungeonInfoDtoResponse.MonsterDtoResponse(monster.id,
                            monster.name);
            monsters.add(newMonster);
        });
        return new GetDungeonInfoDtoResponse(from.getDungeonName(), monsters);
    }
}
