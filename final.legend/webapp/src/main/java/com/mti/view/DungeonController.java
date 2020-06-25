package com.mti.view;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dungeons")
public class DungeonController {

    @GetMapping("/")
    public void getDungeons() {
        // return the name of the available dungeons
    }

    @GetMapping(path = "{id}")
    public void getDungeon(@PathVariable("id") int dungeonId) {
        // get into dungeon {id} - return enemy to defeat
    }

    @PutMapping(path = "{id}")
    public void attackDungeon(@PathVariable("id") int dungeonId) {

    }
}
