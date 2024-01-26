package com.unito.tweb.javaspringbootservertweb23.game_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
        gameEventService.saveGameEvents(gameEvents);
        return ResponseEntity.ok("GameEvents successfully loaded!");
    }
}
