package com.unito.tweb.javaspringbootservertweb23.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/add_games")
    public ResponseEntity<String> addGames(@RequestBody List<Game> games){
        gameService.saveGames(games);
        return ResponseEntity.ok("Games successfully loaded!");
    }
}
