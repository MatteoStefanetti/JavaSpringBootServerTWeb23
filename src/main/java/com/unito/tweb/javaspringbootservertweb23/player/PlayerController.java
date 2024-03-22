package com.unito.tweb.javaspringbootservertweb23.player;

import com.unito.tweb.javaspringbootservertweb23.dto.PlayerInformation;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerCard;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * REST controller for managing Player entities
 */
@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    /**
     * Constructs a new PlayerController with the provided PlayerService.
     *
     * @param playerService The service used for managing Player entities
     */
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Endpoint for adding multiple players.
     *
     * @param players The list of players to add
     * @return ResponseEntity indicating success or failure of the operation
     */
    @PostMapping("/add_players")
    public ResponseEntity<String> addPlayers(@RequestBody List<Player> players) {
        return playerService.savePlayers(players) != null ? ResponseEntity.ok("Players successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading Players!");
    }

    /**
     * Endpoint for retrieving players whose name contains a specified string.
     *
     * @param name The string to search for in player names
     * @return ResponseEntity containing the list of player cards if found, or a not found response otherwise
     */
    @GetMapping("/get_players_by_name")
    public ResponseEntity<Optional<List<PlayerCard>>> getPlayersByPlayerNameIsContainingOrderByLastName(@RequestBody String name) {
        Optional<List<PlayerCard>> result = playerService.getPlayersByPlayerNameIsContainingOrderByLastName(name);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving players by their country of citizenship.
     *
     * @param country The country of citizenship to filter players by
     * @return ResponseEntity containing the list of players by citizenship if found, or a not found response otherwise
     */
    @GetMapping("/get_players_by_nation")
    public ResponseEntity<Optional<List<PlayerInformation>>> getPlayersByCountryOfCitizenshipOrderByLastName(@RequestBody String country) {
        Optional<List<PlayerInformation>> result = playerService.getPlayersByCountryOfCitizenshipOrderByLastName(country);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for querying player names by their IDs.
     *
     * @param ids The list of player IDs to query
     * @return ResponseEntity containing the list of player names if found, or a not found response otherwise
     */
    @GetMapping("/query_player_names_by_ids")
    public ResponseEntity<Optional<List<PlayerName>>> getPlayersByIds(@RequestBody List<Long> ids) {
        Optional<List<PlayerName>> result = playerService.getPlayersByIds(ids);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving a player by their ID.
     *
     * @param id The ID of the player to retrieve
     * @return ResponseEntity containing the player entity if found, or a not found response otherwise
     */
    @GetMapping("/get_player_by_id")
    public ResponseEntity<Optional<Player>> getPlayerById(@RequestBody Long id) {
        Optional<Player> result = playerService.getPlayerById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
