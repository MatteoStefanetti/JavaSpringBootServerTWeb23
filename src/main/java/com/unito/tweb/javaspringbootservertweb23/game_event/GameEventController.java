package com.unito.tweb.javaspringbootservertweb23.game_event;

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
     * @return a ResponseEntity with a success message if the game events are successfully loaded, or an error message if an error occurred
     */
    @PostMapping("/add_game_events")
    public ResponseEntity<String> addGameEvents(@RequestBody List<GameEvent> gameEvents) {
        return gameEventService.saveGameEvents(gameEvents) != null ? ResponseEntity.ok("GameEvents successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading GameEvents!");
    }

    /**
     * Retrieves a game event by its associated game ID.
     *
     * @param id The ID of the game
     * @return A ResponseEntity containing the game event corresponding to the given game ID if found, or a NOT_FOUND status if not found
     */
    @GetMapping("/get_game_event_by_game_id")
    public ResponseEntity<Optional<GameEvent>> getGameEventById(@RequestBody Long id) {
        Optional<GameEvent> result = gameEventService.getGameEventByGameId(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
