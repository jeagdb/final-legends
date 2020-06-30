package com.mti.dtotoentity;

import com.mti.domain.entity.DungeonInfoEntity;
import com.mti.legendsdb.utils.scope.ConvertService;
import com.mti.view.dto.player.GetDungeonInfoDtoResponse;
import utils.Converter;

import javax.annotation.Resource;
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
                            new GetDungeonInfoDtoResponse.StatDtoResponse(monster.stat.health,
                                    monster.stat.mana,
                                    monster.stat.attack,
                                    monster.stat.defense,
                                    monster.stat.intelligence,
                                    monster.stat.agility), monster.name, monster.xp);
            monsters.add(newMonster);
        });
        return new GetDungeonInfoDtoResponse(from.getDungeonName(), monsters);
    }
}
