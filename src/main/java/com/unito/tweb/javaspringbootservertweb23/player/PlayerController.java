package com.unito.tweb.javaspringbootservertweb23.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/add_players")
    public ResponseEntity<String> addPlayers(@RequestBody List<Player> players) {
        playerService.savePlayers(players);
        return ResponseEntity.ok("Player successfully loaded!");
    }

    @GetMapping("/get_players_by_name")
    public ResponseEntity<List<Player>> getPlayerByLetterInPlayerName(@RequestBody String name) {
        return ResponseEntity.ok(playerService.getPlayerByPlayerName(name));
    }

    @GetMapping("/get_players_by_nation")
    public ResponseEntity<List<Player>> getPlayerByCountryOfCitizenship(@RequestBody String country) {
        return ResponseEntity.ok(playerService.getPlayerByCountryOfCitizenship(country));
    }

    @GetMapping("/get_players_by_ids")
    public ResponseEntity<List<Player>> getPlayersByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(playerService.getPlayersByIds(ids));
    }

    @GetMapping("/get_player_by_id")
    public ResponseEntity<Optional<Player>> getPlayerById(@RequestBody Long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }
}
