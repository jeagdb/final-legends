package com.mti.view.controller;

import com.mti.domain.entity.PlayerEntity;
import com.mti.domain.entity.StatEntity;
import com.mti.domain.entity.VocationEntity;
import com.mti.domain.service.PlayerService;
import com.mti.domain.service.StatService;
import com.mti.domain.service.VocationService;
import com.mti.view.dto.player.GetPlayersDtoResponse;
import com.mti.view.dto.player.PutPlayerDtoRequest;
import com.mti.view.dto.player.PutPlayerDtoResponse;
import org.springframework.web.bind.annotation.*;
import utils.log.CanLog;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/player")
public class PlayerController implements CanLog {

    private PlayerService playerService;
    private VocationService vocationService;
    private StatService statService;

    public PlayerController(PlayerService playerService, VocationService vocationService, StatService statService) {
        this.playerService = playerService;
        this.vocationService = vocationService;
        this.statService = statService;
    }

    @GetMapping("/")
    public GetPlayersDtoResponse getPlayers() {
        List<PlayerEntity> players = playerService.findAllPlayers();
        return new GetPlayersDtoResponse(players.stream().map(playerEntity -> {
            var vocationDto = new GetPlayersDtoResponse.VocationDtoResponse(playerEntity.vocationEntity.name);
            var statDto = new GetPlayersDtoResponse.StatDtoResponse(
                    playerEntity.statEntity.health, playerEntity.statEntity.mana, playerEntity.statEntity.attack,
                    playerEntity.statEntity.defense, playerEntity.statEntity.intelligence, playerEntity.statEntity.agility);
            return new GetPlayersDtoResponse.PlayerDtoResponse(playerEntity.name, playerEntity.level,
                    vocationDto, statDto, playerEntity.experience);
        }).collect(Collectors.toList()));
    }

    @GetMapping("/skills")
    public void getPlayerSkills() {
        // send skills player
    }

    @PutMapping("/")
    public PutPlayerDtoResponse putPlayer(final @RequestBody PutPlayerDtoRequest putPlayerDtoRequest) {
        VocationEntity vocationEntity = vocationService.getVocationByName(putPlayerDtoRequest.vocation);
        if (vocationEntity == null) {
            logger().warn("PlayerController.putPlayer: vocationEntity is null");
        }
        StatEntity statEntity = statService.generatePlayerStatsWithVocation(vocationEntity.id);
        if (statEntity == null) {
            logger().warn("PlayerController.putPlayer: statEntity is null");
        }
        final var entity = new PlayerEntity(
                1,
                putPlayerDtoRequest.name,
                0,
                vocationEntity,
                statEntity,
                0);
        final PlayerEntity result = playerService.save(entity);
        final PutPlayerDtoResponse.VocationDtoResponse vocationDtoResponse = new PutPlayerDtoResponse.VocationDtoResponse(result.vocationEntity.name);
        final PutPlayerDtoResponse.StatDtoResponse statDtoResponse = new PutPlayerDtoResponse.StatDtoResponse(
                result.statEntity.health,
                result.statEntity.mana,
                result.statEntity.attack,
                result.statEntity.defense,
                result.statEntity.intelligence,
                result.statEntity.agility);
        return new PutPlayerDtoResponse(result.name, result.level, vocationDtoResponse, statDtoResponse, result.experience);
    }

}