package com.mti.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    // Au niveau des noms, à revoir
    @GetMapping("/")
    public void getPlayer() {
        // send infos player
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