package com.unito.tweb.javaspringbootservertweb23.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/add_players")
    public ResponseEntity<String> addPlayers(@RequestBody List<Player> players){
        playerService.savePlayers(players);
        return ResponseEntity.ok("Player successfully loaded!");
    }

    @GetMapping("/get_players_by_letter")
    public ResponseEntity<List<Long>> getPlayerByLetterInPlayerName(@RequestBody List<String> letter){
        return ResponseEntity.ok(playerService.getPlayerByLetterInPlayerName(letter.get(0), letter.get(1)));
    }
}
