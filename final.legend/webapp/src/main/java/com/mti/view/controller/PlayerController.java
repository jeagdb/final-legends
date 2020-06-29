package com.mti.view.controller;

import com.mti.domain.entity.PlayerEntity;
import com.mti.domain.entity.StatEntity;
import com.mti.domain.entity.VocationEntity;
import com.mti.domain.service.PlayerService;
import com.mti.view.dto.player.GetPlayersDtoResponse;
import com.mti.view.dto.player.PutPlayerDtoRequest;
import com.mti.view.dto.player.PutPlayerDtoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public GetPlayersDtoResponse getPlayers() {
        List<PlayerEntity> players = playerService.findAllPlayers();
        return new GetPlayersDtoResponse(players.stream().map(playerEntity -> {
            var vocationDto = new GetPlayersDtoResponse.VocationDtoResponse(playerEntity.vocationEntity.id, playerEntity.vocationEntity.name);
            var statDto = new GetPlayersDtoResponse.StatDtoResponse(playerEntity.statEntity.id,
                    playerEntity.statEntity.health, playerEntity.statEntity.mana, playerEntity.statEntity.attack,
                    playerEntity.statEntity.defense, playerEntity.statEntity.intelligence, playerEntity.statEntity.agility);
            return new GetPlayersDtoResponse.PlayerDtoResponse(playerEntity.id, playerEntity.name, playerEntity.level,
                    vocationDto, statDto, playerEntity.experience);
        }).collect(Collectors.toList()));
    }

    @GetMapping("/skills")
    public void getPlayerSkills() {
        // send skills player
    }

    @PutMapping("/")
    public PutPlayerDtoResponse putPlayer(final @RequestBody PutPlayerDtoRequest putPlayerDtoRequest) {
        final VocationEntity vocationEntity = new VocationEntity(putPlayerDtoRequest.vocationId.id,
                putPlayerDtoRequest.vocationId.name);
        final StatEntity statEntity = new StatEntity(putPlayerDtoRequest.statId.id,
                putPlayerDtoRequest.statId.health,
                putPlayerDtoRequest.statId.mana,
                putPlayerDtoRequest.statId.attack,
                putPlayerDtoRequest.statId.defense,
                putPlayerDtoRequest.statId.intelligence,
                putPlayerDtoRequest.statId.agility);
        final var entity = new PlayerEntity(putPlayerDtoRequest.id,
                putPlayerDtoRequest.name,
                putPlayerDtoRequest.level,
                vocationEntity,
                statEntity,
                putPlayerDtoRequest.experience);
        final PlayerEntity result = playerService.save(entity);
        final PutPlayerDtoResponse.VocationDtoResponse vocationDtoResponse = new PutPlayerDtoResponse.VocationDtoResponse(result.vocationEntity.id, result.vocationEntity.name);
        final PutPlayerDtoResponse.StatDtoResponse statDtoResponse = new PutPlayerDtoResponse.StatDtoResponse(result.statEntity.id,
                result.statEntity.health,
                result.statEntity.mana,
                result.statEntity.attack,
                result.statEntity.defense,
                result.statEntity.intelligence,
                result.statEntity.agility);
        return new PutPlayerDtoResponse(result.id, result.name, result.level, vocationDtoResponse, statDtoResponse, result.experience);
    }

}