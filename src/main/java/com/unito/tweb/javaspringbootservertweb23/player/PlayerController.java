package com.unito.tweb.javaspringbootservertweb23.player;

import com.unito.tweb.javaspringbootservertweb23.dto.PlayerCard;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerName;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
     * Constructs a new {@code PlayerController} with the provided {@link PlayerService}.
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
     * @return {@link ResponseEntity} indicating success or failure of the operation
     */
    @Operation(summary = "Add players",
            description = "Add a list of players to the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Players successfully loaded",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500",
                    description = "Error occurred while loading players",
                    content = @Content())
    })
    @PostMapping("/add_players")
    public ResponseEntity<String> addPlayers(@RequestBody List<Player> players) {
        return playerService.savePlayers(players) != null ? ResponseEntity.ok("Players successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading Players!");
    }

    /**
     * Endpoint for retrieving players whose name contains a specified string.
     *
     * @param name The string to search for in player names
     * @return {@link ResponseEntity} containing the {@link List} of {@link PlayerCard} if found, or a not found response otherwise
     */
    @Operation(summary = "Get players by name",
            description = "Retrieve a list of players whose name contains the specified substring, ordered by last name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of players",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlayerCard.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No players found with the specified name",
                    content = @Content())
    })
    @GetMapping("/get_players_by_name/{name}")
    public ResponseEntity<Optional<List<PlayerCard>>> getPlayersByPlayerNameIsContainingOrderByLastName(@PathVariable String name) {
        Optional<List<PlayerCard>> result = playerService.getPlayersByPlayerNameIsContainingOrderByLastName(name);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving players by their country of citizenship.
     *
     * @param country The country of citizenship to filter players by
     * @return {@link ResponseEntity} containing the {@link List} of {@link PlayerCard} by citizenship if found, or a not found response otherwise
     */
    @Operation(summary = "Get players by country",
            description = "Retrieve a list of players by their country of citizenship, ordered by last name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of players",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlayerCard.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No players found with the specified country",
                    content = @Content())
    })
    @GetMapping("/get_players_by_nation/{country}")
    public ResponseEntity<Optional<List<PlayerCard>>> getPlayersByCountryOfCitizenshipOrderByLastName(@PathVariable String country) {
        Optional<List<PlayerCard>> result = playerService.getPlayersByCountryOfCitizenshipOrderByLastName(country);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for querying player names by their IDs.
     *
     * @param ids The list of player IDs to query
     * @return {@link ResponseEntity} containing the {@link List} of {@link PlayerCard} if found, or a not found response otherwise
     */
    @Operation(summary = "Get players names by IDs",
            description = "Retrieve a list of player cards by their IDs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of player cards",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlayerCard.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No players found with the specified IDs",
                    content = @Content())
    })
    @GetMapping("/query_players_by_ids/{ids}")
    public ResponseEntity<Optional<List<PlayerCard>>> getPlayersCardsByIds(@PathVariable List<Long> ids) {
        Optional<List<PlayerCard>> result = playerService.getPlayersCardsByIds(ids);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving a player by their ID.
     *
     * @param id The ID of the player to retrieve
     * @return {@link ResponseEntity} containing the {@link Player} entity if found, or a not found response otherwise
     */
    @Operation(summary = "Get player by ID",
            description = "Retrieve a player by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the player",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "404",
                    description = "Player not found",
                    content = @Content())
    })
    @GetMapping("/get_player_by_id/{id}")
    public ResponseEntity<Optional<Player>> getPlayerById(@PathVariable Long id) {
        Optional<Player> result = playerService.getPlayerById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving player cards by their IDs.
     *
     * @param ids The list of player IDs to query
     * @return {@link ResponseEntity} containing the {@link List} of {@link PlayerCard} if found, or a not found response otherwise
     */
    @Operation(summary = "Get players by IDs",
            description = "Retrieve a list of player cards by their IDs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of player cards",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlayerCard.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No players found with the specified IDs",
                    content = @Content())
    })
    @GetMapping("/get_players_by_ids/{ids}")
    public ResponseEntity<Optional<List<PlayerCard>>> getPlayersByIds(@PathVariable List<Long> ids) {
        Optional<List<PlayerCard>> result = playerService.getPlayersByIds(ids);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
