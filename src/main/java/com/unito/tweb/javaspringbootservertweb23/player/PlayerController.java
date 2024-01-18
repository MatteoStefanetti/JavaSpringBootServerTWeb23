package com.unito.tweb.javaspringbootservertweb23.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/addPlayers")
    public ResponseEntity<String> addPlayers(@RequestBody List<Player> players){
        playerService.savePlayers(players);
        return ResponseEntity.ok("Player successfully loaded!");
    }
}
