package com.unito.tweb.javaspringbootservertweb23.game_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/game_events")
public class GameEventController {
    private final GameEventService gameEventService;

    @Autowired
    public GameEventController(GameEventService gameEventService) {
        this.gameEventService = gameEventService;
    }

    @PostMapping("/add_game_events")
    public ResponseEntity<String> addGameEvents(@RequestBody List<GameEvent> gameEvents){
        return gameEventService.saveGameEvents(gameEvents) != null ? ResponseEntity.ok("GameEvents successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading GameEvents!");
    }

    @GetMapping("/get_game_event_by_game_id")
    public ResponseEntity<Optional<GameEvent>> getGameEventById(@RequestBody Long id){
        Optional<GameEvent> result = gameEventService.getGameEventByGameId(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
