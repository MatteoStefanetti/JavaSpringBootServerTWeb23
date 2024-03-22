package com.unito.tweb.javaspringbootservertweb23.player;

import com.unito.tweb.javaspringbootservertweb23.dto.PlayerByCitizenship;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerCard;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Optional<List<PlayerCard>>> getPlayersByPlayerNameIsContainingOrderByLastName(@RequestBody String name) {
        Optional<List<PlayerCard>> result = playerService.getPlayersByPlayerNameIsContainingOrderByLastName(name);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get_players_by_nation")
    public ResponseEntity<Optional<List<PlayerByCitizenship>>> getPlayersByCountryOfCitizenshipOrderByLastName(@RequestBody String country) {
        Optional<List<PlayerByCitizenship>> result = playerService.getPlayersByCountryOfCitizenshipOrderByLastName(country);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/query_player_names_by_ids")
    public ResponseEntity<Optional<List<PlayerName>>> getPlayersByIds(@RequestBody List<Long> ids) {
        Optional<List<PlayerName>> result = playerService.getPlayersByIds(ids);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get_player_by_id")
    public ResponseEntity<Optional<Player>> getPlayerById(@RequestBody Long id) {
        Optional<Player> result = playerService.getPlayerById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
