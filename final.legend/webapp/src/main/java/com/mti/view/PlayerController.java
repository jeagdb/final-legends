package com.mti.view;

import com.mti.domain.entity.PlayerEntity;
import com.mti.domain.service.PlayerService;
import com.mti.legendsdb.view.playercontroller.GetPlayersDtoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            var classDto = new GetPlayersDtoResponse.ClassDtoResponse(playerEntity.classEntity.id, playerEntity.classEntity.name);
            var statDto = new GetPlayersDtoResponse.StatDtoResponse(playerEntity.statEntity.id,
                    playerEntity.statEntity.health, playerEntity.statEntity.mana, playerEntity.statEntity.attack,
                    playerEntity.statEntity.defense, playerEntity.statEntity.intelligence, playerEntity.statEntity.agility);
            return new GetPlayersDtoResponse.PlayerDtoResponse(playerEntity.id, playerEntity.name, playerEntity.level,
                    classDto, statDto, playerEntity.experience);
        }).collect(Collectors.toList()));
    }

    @GetMapping("/skills")
    public void getPlayerSkills() {
        // send skills player
    }

    @PutMapping("/")
    public void putPlayer() {
        // create new player
    }

}