package com.unito.tweb.javaspringbootservertweb23.game_event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Controller class for managing game events.
 */
@RestController
@RequestMapping("/game_events")
public class GameEventController {
    private final GameEventService gameEventService;

    /**
     * Constructs a new {@code GameEventController} with the specified {@link GameEventService}.
     *
     * @param gameEventService The service for game events
     */
    @Autowired
    public GameEventController(GameEventService gameEventService) {
        this.gameEventService = gameEventService;
    }

    /**
     * Adds a list of game events.
     *
     * @param gameEvents The list of game events to add
     * @return a {@link ResponseEntity} with a success message if the game events are successfully loaded, or an error message if an error occurred
     */
    @Operation(summary = "Add game events",
            description = "Add a list of game events to the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Game events successfully loaded",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500",
                    description = "Error occurred while loading game events",
                    content = @Content())
    })
    @PostMapping("/add_game_events")
    public ResponseEntity<String> addGameEvents(@RequestBody List<GameEvent> gameEvents) {
        return gameEventService.saveGameEvents(gameEvents) != null ? ResponseEntity.ok("GameEvents successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading GameEvents!");
    }

    /**
     * Retrieves a game event by its associated game ID.
     *
     * @param id The ID of the game
     * @return A {@link ResponseEntity} containing the {@link List} of {@link GameEvent} corresponding to the given game ID if found, or a NOT_FOUND status if not found
     */
    @Operation(summary = "Get game events by game ID",
            description = "Retrieve a list of game events based on the specified game ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the game events list",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GameEvent.class)))),
            @ApiResponse(responseCode = "404",
                    description = "Game events not found",
                    content = @Content())
    })
    @GetMapping("/get_game_events_by_game_id/{id}")
    public ResponseEntity<Optional<List<GameEvent>>> getGameEventsById(@PathVariable Long id) {
        Optional<List<GameEvent>> result = gameEventService.getGameEventsByGameId(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
