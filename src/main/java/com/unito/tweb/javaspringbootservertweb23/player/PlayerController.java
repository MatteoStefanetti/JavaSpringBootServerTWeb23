package com.unito.tweb.javaspringbootservertweb23.player;

import com.unito.tweb.javaspringbootservertweb23.dto.PlayerByCitizenship;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        return playerService.savePlayers(players) != null ? ResponseEntity.ok("Players successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading Players!");
    }

    @GetMapping("/get_players_by_name")
    public ResponseEntity<List<Long>> getPlayersByPlayerNameIsContainingOrderByLastName(@RequestBody String name) {
        return ResponseEntity.ok(playerService.getPlayersByPlayerNameIsContainingOrderByLastName(name));
    }

    @GetMapping("/get_players_by_nation")
    public ResponseEntity<List<PlayerByCitizenship>> getPlayersByCountryOfCitizenshipOrderByLastName(@RequestBody String country) {
        return ResponseEntity.ok(playerService.getPlayersByCountryOfCitizenshipOrderByLastName(country));
    }

    @GetMapping("/query_player_names_by_ids")
    public ResponseEntity<List<PlayerName>> getPlayersByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(playerService.getPlayersByIds(ids));
    }

    @GetMapping("/get_player_by_id")
    public ResponseEntity<Optional<Player>> getPlayerById(@RequestBody Long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }
}
